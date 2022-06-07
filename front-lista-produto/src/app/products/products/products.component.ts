import { ProductsService } from './../services/products.service';
import { Product } from './../model/product';
import { Component, OnInit } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products$: Observable<Product[]>;
  displayedColumns = ['name', 'targetMarket', 'description'];

  //productsService: ProductsService;



  constructor(
    private productsService: ProductsService,
    public dialog: MatDialog) {
    //this.productsService = new ProductsService();
    this.products$ = this.productsService.list()
    .pipe(
      catchError(error =>{
        this.onError('Erro ao carregar produtos.');
        return of([])
      })
    );
  }

  onError(errorMSG: string) {
    this.dialog.open(ErrorDialogComponent, {
      data:errorMSG
    });
  }

  ngOnInit(): void {
    
  }

}
