SELECT
SUBSTR(PRODUCT_CODE, 0, 2) AS CATEGORY
, COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY SUBSTR(PRODUCT_CODE, 0, 2)
ORDER BY CATEGORY