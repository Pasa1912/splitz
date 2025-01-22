package com.pennyplanner.splitz.service;

import com.pennyplanner.splitz.model.Currency;
import com.pennyplanner.splitz.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository CurrencyRepository;

    public Currency createCurrency(String name, String symbol) {
        Currency currency = new Currency(name, symbol);
        return CurrencyRepository.save(currency);
    }

    public Optional<Currency> getCurrencyById(Long id) {
        return CurrencyRepository.findById(id);
    }

    public List<Currency> getAllCurrencies() {
        return CurrencyRepository.findAll();
    }

    public Currency updateCurrency(Long id, String name, String symbol) {
        Currency currency = CurrencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency not found"));

        currency.setName(name);
        currency.setSymbol(symbol);

        return CurrencyRepository.save(currency);
    }

    public void deleteCurrency(Long id) {
        if (!CurrencyRepository.existsById(id)) {
            throw new RuntimeException("Currency not found");
        }
        CurrencyRepository.deleteById(id);
    }
}
