package com.pennyplanner.splitz.service;

import com.pennyplanner.splitz.model.Settlement;
import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SettlementService {

    private final SettlementRepository SettlementRepository;

    public Settlement createSettlement(User payer, User user, Double amount, String currencyCode, String settlementDate, String paymentMethod) {
        Settlement settlement = new Settlement(payer, user, amount, currencyCode, settlementDate, paymentMethod);
        return SettlementRepository.save(settlement);
    }

    public Optional<Settlement> getSettlementById(Long id) {
        return SettlementRepository.findById(id);
    }

    public List<Settlement> getAllSettlements() {
        return SettlementRepository.findAll();
    }

    public Settlement updateSettlement(Long id, User payer, User user, Double amount, String currencyCode, LocalDateTime settlementDate, String paymentMethod) {
        Settlement settlement = SettlementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Settlement not found"));

        settlement.setUser(user);
        settlement.setPayer(payer);
        settlement.setAmount(amount);
        settlement.setCurrencyCode(currencyCode);
        settlement.setSettlementDate(settlementDate);
        settlement.setPaymentMethod(paymentMethod);

        return SettlementRepository.save(settlement);
    }

    public void deleteSettlement(Long id) {
        if (!SettlementRepository.existsById(id)) {
            throw new RuntimeException("Settlement not found");
        }
        SettlementRepository.deleteById(id);
    }
}
