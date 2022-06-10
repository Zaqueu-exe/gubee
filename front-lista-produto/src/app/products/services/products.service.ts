import { Product } from './../model/product';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { delay, first, tap, Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private readonly API = 'products';

  constructor(private httpClient: HttpClient) {
  }

  listAll() {
    return this.httpClient.get<Product[]>(this.API)
      .pipe(
        first(),
        delay(1500),
        tap(products => console.log(products))
      );
  }

  getByTechnology(name: String): Observable<any> {
    return this.httpClient.get<Product[]>(`${this.API}/technologies/${name}`);
  }

  getByTargetMarket(targetMarket: String): Observable<any> {
    return this.httpClient.get<Product[]>(`${this.API}/targetmarket/${targetMarket}`);
  }
}
