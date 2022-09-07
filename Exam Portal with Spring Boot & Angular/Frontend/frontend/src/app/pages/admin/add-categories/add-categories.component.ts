import { HttpBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-categories',
  templateUrl: './add-categories.component.html',
  styleUrls: ['./add-categories.component.css']
})
export class AddCategoriesComponent implements OnInit {

  categories={
      title:'',
      description:''
    }

  constructor(
    private service:CategoryService,
    private snack:MatSnackBar
  ) { }

  ngOnInit(): void {
  }

  public formSubmit(){
    if(this.categories.title.trim()=='' || this.categories.title==null ){
      this.snack.open("Title Required !!!")
      return;
    }
    else if(this.categories.description.trim()=='' || this.categories.description==null ){
      this.snack.open("Description Required !!!")
      return;
    }

    this.service.addCategory(this.categories).subscribe(
      (data:any)=>{
        console.log(data);
        
        Swal.fire("success","Added Successfully")
        window.location.href='/category'
        this.categories.title=''
        this.categories.description=''
        
      },
      (error)=>{
        console.log(error);
        Swal.fire("error","server error")
        
      }
    )

  }

}
