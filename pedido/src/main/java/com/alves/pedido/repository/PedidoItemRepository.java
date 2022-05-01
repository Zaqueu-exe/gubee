package com.alves.pedido.repository;

import com.alves.pedido.Domain.PedidoItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoItemRepository extends MongoRepository<PedidoItem, String> {
}
