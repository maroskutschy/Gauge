Facebook - modify comment
=========================

Prepare test data - Context steps
* Using Facebook Graph API, I post on Nessathon2018's page feed "Gauge is a free and open source test automation framework that takes the pain out of acceptance testing"
* Using Facebook Graph API, I make a comment "It's great tool!"

* In Facebook app, I successfully login to facebook with email "jasecuframework@gmail.com" and password "Jasecu12"
* In Facebook app, I navigate to the Nessathon2018 page


Edit comment for my post
---------------------------
* In Facebook app, I edit my last comment "Automated test can be created with the speed of sound!"
* In Facebook app, I verify that comment is correct


Delete comment for my post
---------------------------
* In Facebook app, I delete my last comment
* In Facebook app, I verify that comment was deleted
___
Delete test data - Tear down step
*  Using Facebook Graph API, I remove post