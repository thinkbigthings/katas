# DateService
Provides computations on calendar dates.
This could be part of a RESTful web service to determine birthdays that belong to minors.


## Assumptions

- We'll define minor as ages that are less than 18 years old as of today in the local time zone
- We'll allow input requiring the ordering of month/day/year but with variable-length dates, so 04/04/1996 is as valid as 4/4/96
- This service only works for people less than 100 years old and assumes input dates are always in the past. 
  I'd recommend enforcing 4-digit year in input, otherwise you have know way of knowing if a two digit date is a newborn or a centarian.

## Topics for further discussion
- What about when streaming over a list (in the controller) when the date changes? 
  Is it ok that we evaluate part of the list for one day and part for the next? I presume it's ok.
- Dates do have timezones associated with them, this server assumes all requests are in the local time zone.
  If it's noon in Philly and 1AM in Taipei, the Taipei resident who just had their 18th birthday would still be considered a minor.
  You'd probably want to convert the current date and the request date to the same timezone for purposes of comparison.
  Conveniently, Spring controllers can bind the TimeZone of the http request as a controller method argument.





