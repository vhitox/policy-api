package policy.api

class BootStrap {

    def init = { servletContext ->
    new Policy(number: 32, amount: 45).save()
    new Policy(number: 15, amount: 25).save()
    new Policy(number: 98, amount: 36).save()
    }
    def destroy = {
    }
}
