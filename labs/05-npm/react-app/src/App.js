import React, { useState } from 'react';
import './App.css';

const OPERATIONS = ['+', '-', '*', '/'];

const calculate = (a, b, operation) => {
  const first = Number(a);
  const second = Number(b);

  switch (operation) {
    case '+':
      return first + second;
    case '-':
      return first - second;
    case '*':
      return first * second;
    case '/':
      if (second === 0) {
        throw new Error('Деление на ноль невозможно');
      }
      return first / second;
    default:
      return 0;
  }
};

const App = () => {
  const [first, setFirst] = useState('12');
  const [second, setSecond] = useState('8');
  const [operation, setOperation] = useState('*');
  const [result, setResult] = useState('96');
  const [error, setError] = useState('');

  const onCalculate = () => {
    try {
      setError('');
      setResult(String(calculate(first, second, operation)));
    } catch (exception) {
      setResult('');
      setError(exception.message);
    }
  };

  return (
    <main className="app">
      <section className="card">
        <p className="eyebrow">Лабораторная работа №5</p>
        <h1>Калькулятор</h1>
        <p className="subtitle">React, ESLint 7.11, Airbnb, Prettier 2.4</p>

        <div className="grid">
          <label htmlFor="first">
            Первое число
            <input
              id="first"
              type="number"
              value={first}
              onChange={event => setFirst(event.target.value)}
            />
          </label>

          <label htmlFor="operation">
            Операция
            <select
              id="operation"
              value={operation}
              onChange={event => setOperation(event.target.value)}
            >
              {OPERATIONS.map(item => (
                <option key={item} value={item}>
                  {item}
                </option>
              ))}
            </select>
          </label>

          <label htmlFor="second">
            Второе число
            <input
              id="second"
              type="number"
              value={second}
              onChange={event => setSecond(event.target.value)}
            />
          </label>
        </div>

        <button type="button" onClick={onCalculate}>
          Вычислить
        </button>

        {error ? <p className="error">{error}</p> : <p className="result">= {result}</p>}

        <footer>Лукьянов Никита Сергеевич, группа ИТ-19</footer>
      </section>
    </main>
  );
};

export default App;
