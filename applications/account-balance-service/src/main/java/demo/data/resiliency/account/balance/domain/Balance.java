package demo.data.resiliency.account.balance.domain;

/**
 *  "AccountId": "22289",
 *         "Amount": {
 *           "Amount": "1230.00",
 *           "Currency": "GBP"
 *         }
 */
public record Balance(String id, Amount amount) {
}
