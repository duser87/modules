CREATE TABLE IF NOT EXISTS orders
(
    "id" bigint primary key not null,
    "article" varchar,
    "quantity" bigint,
    "sum" bigint,
    "data" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp
);

COMMENT ON table orders IS 'The table orders';
COMMENT ON COLUMN orders.id IS 'ID order';
COMMENT ON COLUMN orders.article IS 'Article order';
COMMENT ON COLUMN orders.quantity IS 'Quantity order';
COMMENT ON COLUMN orders.sum IS 'Sum order';