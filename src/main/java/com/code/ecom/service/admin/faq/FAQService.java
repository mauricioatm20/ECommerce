package com.code.ecom.service.admin.faq;

import com.code.ecom.dto.FAQDto;

public interface FAQService {

    FAQDto postFAQ(Long productId, FAQDto faqDto);
}
