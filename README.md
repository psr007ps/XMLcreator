# XMLcreator

An application that takes the user data from a csv file to create a bulk of xml documents.
The user data must contain the information required to identify a unique user account. These files are created for but not limited to process using the console of Sailpoint IdentityIQ.

Sailpoint IIQ is an identity-management system used for enterprise or cross-network identity management.

XML bulk file gerator is an open-sorce application designed for scenarios which may include mass-layoffs(terminations), mass-onboarding events or access change/revoke for a large number of users.

In such scenarios, submitting a request through IIQ UI may take a long time to process the workflows and is difficult to perform when the number of users is large. 

The request therefore can be taken up by the developer in such cases and these events can be triggered from the backend using IIQ-console. 

However, a xml file needs to be processed for each user to trigger the appropriate workflow and this application can be used to create such files or some other xml files just by tweeking the parameters.
