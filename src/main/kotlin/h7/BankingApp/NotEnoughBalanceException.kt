package h7.BankingApp

import java.lang.Exception

class NotEnoughBalanceException : Exception("Not enough balance")

class AccountNotFoundException : Exception("Account does not exist")
