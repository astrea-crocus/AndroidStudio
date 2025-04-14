import 'package:flutter/material.dart';
import 'package:animate_do/animate_do.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  int _counter = 0;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Super Appli',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Ma première Application Flutter'),
          backgroundColor: Colors.deepPurple,
          foregroundColor: Colors.white,
        ),
        body: Center(
          child: FloatingActionButton(onPressed: () {
            _incremementCounter();
          },
          child: Text('Click'),
          )
        ),
      ),
    );
  }

  void _incremementCounter() {
    _counter++;
    print("Compteur : ${_counter.toString()}");
  }
}

