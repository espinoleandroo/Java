package io.espinoleandroo.java.Spring.domain.repository;

import java.util.List;
import java.util.Optional;

import io.espinoleandroo.java.Spring.domain.Purchase;

public interface PurchaseRepository {
	List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
