SELECT * FROM logs.log

where date between '2017-01-01.15:00:00' and '2017-01-01.15:59:59'

GROUP BY ipAddress

HAVING count(ipAddress) >=200



;