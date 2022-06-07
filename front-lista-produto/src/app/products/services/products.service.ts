import { Product } from './../model/product';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { delay, first, tap } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private readonly API = '/assets/products.json';

  constructor(private httpClient: HttpClient) { 
  
  }

  list(){
    return this.httpClient.get<Product[]>(this.API)
    .pipe(
      first(),
      delay(1500),
      tap(products => console.log(products))
    );
  }
}
