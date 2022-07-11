import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { first, take, tap } from 'rxjs';
import { Product } from '../model/product';
import { Technology } from '../model/technology';
@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private readonly API = environment.API;

  constructor(private http: HttpClient) { }

  getAllProducts() {
    return this.http.get<Product[]>(`${this.API}/products/all`)
      .pipe(
        take(1)
      );
  }

  getProductByTechnologies(TechnologyName: string) {
    return this.http.get<Product[]>(`${this.API}/products/technologies/${TechnologyName}`)
      .pipe(
        take(1)
      );
  }

  getProductByTargetMarket(targetMarket: string) {
    console.log(targetMarket)
    console.log(this.API)
    return this.http.get<Product[]>(`${this.API}/products/targetmarket/${targetMarket}`)
      .pipe(
        first(),
      );
  }

  getAllTechnology() {
    return this.http.get<Technology[]>('http://localhost:8080/technologies/all')
      .pipe(
        first(),
      );
  }
}
