package talk.wipmbl

import grails.transaction.Transactional

@Transactional
class UserService {

    def findAllUsersWithCriteria(someCriteria) {
        // ...
    }


    // *** creation, and save data

    def createNewUser(String name, String address, Integer age, String place, ...) {
        def place = new Place(place)
        def role = new Role(dataR)
        def boss = new User(dataB)

        def user = new User(name:name, address:address, role:role, ...)
        user.addToPlaces(place)
        user.setBoss(boss)

        user.save()

        return user
    }

    def updateUser(Long userId, someData) {
        def user = User.get(userId)
        user.setSomeData(someData)
        user.addToPlaces(new Place(data))
        // using hstore with postgresql extension plugin
        user.setAttributesHstore(mapAttributes)
        user.save()

        // save to mongo
        new UserMongo(data).save()
        // or
        userMongoService.saveUser(data, place)
        // there is a beforeUpdate()

        if (user.hasErrors()) {
            throw new CustomException(user.errors)
        }
    }

    // *** queries

    def findAllUsers() {
        // ...
    }

    def findFollowersFromUser(User user) {
        def c = User.createCriteria().list {
            // ...
        }
    }

    // *** Business Logic

    def getAllMyBankAccountsBalance() {
        def c = UserBank.createCriteria().list {
            eq 'userId' user
            // ...
        }
    }

    def transferMoneyFromMyDefaultBankAccount(Account destinationAccount) {
        // check if a got money
        def account = serviceAccount.getAccount(destinationAccount)

        // check if transfer is possible to destination account
                // ...
        // save transfer to consolidate this night
        new Transfer(fromAccount, toAccount, ammount).save()

        // send an email
        emailService.setnEmail(toUser, subject, ...)
        // send an sms
        smsService.send(...)

        // send a push notification to android bank app
        notificationService.push(...)
    }
}

