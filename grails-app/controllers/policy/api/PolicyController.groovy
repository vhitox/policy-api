package policy.api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PolicyController {

    PolicyService policyService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond policyService.list(params), model:[policyCount: policyService.count()]
    }

    def show(Long id) {
        respond policyService.get(id)
    }

    def save(Policy policy) {
        if (policy == null) {
            render status: NOT_FOUND
            return
        }

        try {
            policyService.save(policy)
        } catch (ValidationException e) {
            respond policy.errors, view:'create'
            return
        }

        respond policy, [status: CREATED, view:"show"]
    }

    def update(Policy policy) {
        if (policy == null) {
            render status: NOT_FOUND
            return
        }

        try {
            policyService.save(policy)
        } catch (ValidationException e) {
            respond policy.errors, view:'edit'
            return
        }

        respond policy, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        policyService.delete(id)

        render status: NO_CONTENT
    }
}
