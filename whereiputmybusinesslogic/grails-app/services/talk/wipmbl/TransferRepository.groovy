package talk.wipmbl

import grails.transaction.Transactional

@Transactional
class TransferRepository {

    def insertTransfer(fromAccount, toAccount, ammount) {
        new Transfer(fromAccount, toAccount, ammount).save()
    }
}
