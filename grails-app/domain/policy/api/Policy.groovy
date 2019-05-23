package policy.api

class Policy {

    int number
    int amount

    static constraints = {
    number blamk:false
    amount blank:false
    }
}
