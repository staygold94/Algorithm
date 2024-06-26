SELECT
FLAVOR
FROM (
    SELECT
    F.FLAVOR
    , ROW_NUMBER() OVER(ORDER BY SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) DESC) AS RN
    FROM FIRST_HALF F
    INNER JOIN JULY J ON F.FLAVOR = J.FLAVOR
    GROUP BY F.FLAVOR
    ORDER BY SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) DESC
) T1
WHERE RN <= 3
ORDER BY RN