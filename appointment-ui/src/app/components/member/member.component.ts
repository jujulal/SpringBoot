import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {RequestOptions} from "http";

@Component({
  selector: 'member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {

  firstName : string = '';
  lastName : string = '';

  memberList: Array<MemberResponse> = [];

  constructor(private http : HttpClient) { }

  ngOnInit() {

    this.http.get('http://localhost:8080/member/getAllMember')
      .subscribe(
        data => {
          this.memberList = data;
          console.log(data);
        }
      )
  }

  addMember(){

    const req =
    this.http.post('http://localhost:8080/member/createMember',
      {
        firstName : this.firstName,
        lastName : this.lastName
      })
      .subscribe(
        res =>{
          this.firstName = '';
          this.lastName = '';
          console.log(res);
        },
      err =>{
          console.log("Error !!!");
      }
    );
  }

  deleteMember(member : MemberResponse){
    let myheaders = new HttpHeaders({'Content-Type':'application/json','Accept':'application/json'});

    const req =
    this.http.delete('http://localhost:8080/member/delete/'+member.id, {headers:myheaders})
      .subscribe(
        res =>{
          console.log('Delete Successfull!' + member);
        },
        err =>{
          console.log("Cannot delete!");
        }
      )
    console.log(member);
  }

}


interface MemberResponse {
  id: number;
  firstName: string;
  lastName: string;
}
