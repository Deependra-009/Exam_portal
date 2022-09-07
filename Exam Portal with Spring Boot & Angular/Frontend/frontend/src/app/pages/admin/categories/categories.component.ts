import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories=[
    {
      cid:'',
      title:'',
      description:''
    }
  ]

  constructor(
    private service:CategoryService
  ) { }

  ngOnInit(): void {

    this.service.category().subscribe(
      (data:any)=>{
        this.categories=data;
        console.log(this.categories);
        
        
      },
      (error)=>{
        console.log(error);
        
      }
    )
  }

}
