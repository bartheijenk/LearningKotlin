package h11.bankappv2

import java.lang.Exception

class NotEnoughBalanceException : Exception("Not enough balance")

class AccountNotFoundException : Exception("Account does not exist")
