SELECT
TO_NUMBER(TO_CHAR(START_DATE, 'MM')) AS MONTH
, CAR_ID
, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE
START_DATE >= TO_DATE('2022-08', 'YYYY-MM')
AND START_DATE < TO_DATE('2022-11', 'YYYY-MM')
AND CAR_ID IN
(
    SELECT
    CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= TO_DATE('2022-08', 'YYYY-MM')
    AND START_DATE < TO_DATE('2022-11', 'YYYY-MM')
    GROUP BY CAR_ID
    HAVING COUNT(HISTORY_ID) >= 5
)

GROUP BY TO_CHAR(START_DATE, 'MM'), CAR_ID
HAVING COUNT(HISTORY_ID) > 0
ORDER BY TO_CHAR(START_DATE, 'MM'), CAR_ID DESC