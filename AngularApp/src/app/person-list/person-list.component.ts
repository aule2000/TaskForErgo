import {Component, Input, OnInit} from '@angular/core';
import {Person} from '../person';
import {PersonService} from '../person.service';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {
  @Input() persons : Person[];
  pipe = new DatePipe('en-US');
  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.personService.findAll().subscribe(data => {
      this.persons = data;
      this.persons.forEach(x =>
        x.birthDate = this.pipe.transform(x.birthDate, 'yyyy-MM-dd'));
    });


  }

}
