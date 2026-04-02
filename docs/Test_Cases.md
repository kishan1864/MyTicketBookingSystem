# Test Cases

| Test ID | Module | Description | Expected Result | Status |
|---|---|---|---|---|
| TC-01 | Auth | Register a new user with valid details | User account is saved to DB and user can login | Pending |
| TC-02 | Auth | Login with invalid credentials | System rejects login and flashes error message | Pending |
| TC-03 | Admin | Add a new movie | New movie is visible in the active movie listings | Pending |
| TC-04 | Admin | Assign show timing to a movie | The show becomes available on the user booking screen | Pending |
| TC-05 | Booking | User attempts to book an available seat | System blocks seat, creates Ticket entry with SUCCESS status | Pending |
| TC-06 | Booking | User attempts to book an already occupied seat | System rolls back and displays "Seat Unavailable" | Pending |
| TC-07 | Security | Non-admin user tries accessing `/admin/dashboard` | Access is denied, HTTP 403 or redirect to login | Pending |
