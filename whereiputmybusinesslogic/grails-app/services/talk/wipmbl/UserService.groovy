package talk.wipmbl

import grails.transaction.Transactional

@Transactional
class TransferRepository {

    def createTransfer(fromAccount, toAccount, ammount) {
        new Transfer(fromAccount, toAccount, ammount).save()
    }
}

