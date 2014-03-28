package talk.wipmbl

import grails.transaction.Transactional

@Transactional
class BankUserService {
    // *** Business Logic

    def transferMoneyFromDefaultBankAccount(BankUser bankUser, Account destinationAccount) {
        // check if a got money
        def account = bankUser.hasMoneyInDefaultAccount()
        if (!hasMoney) {
            throw new CustomRunTimeException()
        }

        // check if transfer is possible to destination account
        def isPossible = accountService.isPossibleTransfer(user, destinationAccount)
        if (!isPossible) {
            throw new CustomRunTimeException()
        }

        // save transfer to consolidate this night
        TransferRepository.createTransfer(fromAccount, toAccount, ammount)

        // send notifications
        notificationService.sendNotifications()
    }

}
