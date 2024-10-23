# bank-account-kata

Think of your personal bank account experience. When in doubt, go for the simplest solution

# Requirements

- Deposit and Withdrawal
- Account statement (date, amount, balance)
- Statement printing

The expected result is a service API, and its underlying implementation, that meets the expressed needs.
Nothing more, especially no UI, no persistence.

# User Stories

- US 1:
  In order to save money
  As a bank client
  I want to make a deposit in my account
- US 2:
  In order to retrieve some or all of my savings
  As a bank client
  I want to make a withdrawal from my account
- US 3:
  In order to check my operations
  As a bank client
  I want to see the history (operation, date, amount, balance) of my operations

## To start the project

Follow given instructions

### Prerequisite

You should have installed :

- Java Development Kit (JDK) 17 +
- Apache Maven 3.9.2
- git

### Installation

1. Clone the repository:

```bash
git clone https://github.com/iboussaid/bank-account-kata.git
```

2. change directory to the project root directory

```bash
cd bank-account-kata
```

4. Use maven to test the project:

```bash
 mvn clean verify