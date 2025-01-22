CREATE TABLE IF NOT EXISTS orders
(
    "id" bigint primary key not null,
    "name" varchar,
    "quantity" bigint,
    "sum" bigint
);

COMMENT ON table orders IS 'The table orders';
COMMENT ON COLUMN orders.id IS 'ID order';
COMMENT ON COLUMN orders.name IS 'Name order';
COMMENT ON COLUMN orders.quantity IS 'Quantity order';
COMMENT ON COLUMN orders.sum IS 'Sum order';