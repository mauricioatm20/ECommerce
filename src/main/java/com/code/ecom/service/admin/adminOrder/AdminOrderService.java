package com.code.ecom.service.admin.adminOrder;

import com.code.ecom.dto.AnalyticsResponse;
import com.code.ecom.dto.OrderDto;

import java.util.List;

public interface AdminOrderService {

    List<OrderDto> getAllPlacedOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();
}
