class BankAccount(_deposited: Long, _withdrawn: Long) {
    val deposited: Long = _deposited
    val withdrawn: Long = _withdrawn
    val balance: Long = _deposited - _withdrawn
}