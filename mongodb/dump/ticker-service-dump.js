/**
 * Creates pre-filled demo ticker
 */

print('dump start');

db.tickers.update(
    { "_id": "demo" },
    {
    "_id": "demo",
    "symbol": "AAPL",
    "currency": "USD",
    "exchange": "NYSE",
    "fullName": "Apple"
    },
    { upsert: true }
);

print('dump complete');