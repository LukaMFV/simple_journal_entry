package com.okeicalm.simpleJournalEntry.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {
    @GetMapping("/healthz")
    fun index(): Int {
        return 1
    }
}
