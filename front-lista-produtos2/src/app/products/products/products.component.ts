import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';
import { ProductsService } from '../services/products.service';
import { Technology } from '../model/technology';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  products$: Observable<Product[]> | undefined;
  technologies$: Observable<Technology[]> | undefined;

  constructor(private service: ProductsService) {
    this.findAllProducts();
    this.technologies$ = service.getAllTechnology();
  }

  ngOnInit(): void {

  }

  findAllProducts(): void {
    this.products$ = this.service.getAllProducts();
  }

  findProductByTechnologies(technology: string): void {
    this.products$ = this.service.getProductByTechnologies(technology);
  }

  findProductByTargetMarket(targetMarket: string): void {
    this.products$ = this.service.getProductByTargetMarket(targetMarket);
  }


}
