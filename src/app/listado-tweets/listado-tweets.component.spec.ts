import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoTweetsComponent } from './listado-tweets.component';

describe('ListadoTweetsComponent', () => {
  let component: ListadoTweetsComponent;
  let fixture: ComponentFixture<ListadoTweetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoTweetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoTweetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
