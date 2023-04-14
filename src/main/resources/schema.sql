DROP TABLE IF EXISTS prices;

CREATE TABLE prices
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    brand_id   NUMERIC     NOT NULL,
    start_date VARCHAR(25) NOT NULL,
    end_date   VARCHAR(25) NOT NULL,
    price_list NUMERIC     NOT NULL,
    product_id NUMERIC     NOT NULL,
    priority   NUMERIC     NOT NULL,
    price      NUMERIC(20, 2) NOT NULL,
    curr       VARCHAR(5)  NOT NULL
);
