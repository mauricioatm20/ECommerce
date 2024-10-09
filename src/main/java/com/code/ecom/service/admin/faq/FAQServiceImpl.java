package com.code.ecom.service.admin.faq;

import com.code.ecom.dto.FAQDto;
import com.code.ecom.entity.FAQ;
import com.code.ecom.entity.Product;
import com.code.ecom.repository.FAQRepository;
import com.code.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {

    private final FAQRepository faqRepository;

    private final ProductRepository productRepository;

    public FAQDto postFAQ(Long productId, FAQDto faqDto) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            FAQ faq = new FAQ();

            faq.setProduct(optionalProduct.get());
            faq.setAnswer(faqDto.getAnswer());
            faq.setQuestion(faqDto.getQuestion());

            return faqRepository.save(faq).getFAQDto();
        }
        return null;
    }

}
