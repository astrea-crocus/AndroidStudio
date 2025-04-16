import 'package:expandedgrid/bleu.dart';
import 'package:expandedgrid/vert.dart';
import 'package:flutter/material.dart';

import 'jaune.dart';
import 'main.dart';
import 'rouge.dart';
import 'violet.dart';

class Turquoise extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Menu',
      theme: ThemeData(
        primarySwatch: Colors.teal,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),

      home: MyHomePage(monTitre: 'Utilisation de Menu'),
    );
  }
}

class MyHomePage extends StatelessWidget {
  final String monTitre;

  const MyHomePage({super.key, required this.monTitre});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(monTitre),
        foregroundColor: Colors.white,

        flexibleSpace: ShaderMask(
          shaderCallback:
              (bounds) => LinearGradient(
                begin: Alignment.topCenter,
                end: Alignment.bottomCenter,
                colors: [
                  Colors.black.withValues(alpha: 0.4),
                  Colors.white.withValues(alpha: 0.4),
                ],
              ).createShader(bounds),
          blendMode: BlendMode.softLight,
          child: Container(color: Colors.teal),
        ),
      ),

      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => MyApp()),
          );
        },
        backgroundColor: Colors.teal,
        foregroundColor: Colors.white,
        child: Icon(Icons.arrow_back),
      ),

      body: Center(
        child: Text(
          'Utilisation de Menu (drawer)',
          style: TextStyle(color: Colors.teal, fontSize: 40.0),
        ),
      ),
      drawer: Drawer(
        backgroundColor: Colors.teal[100],
        semanticLabel: 'Mon super menu',
        child: ListView(
          children: <Widget>[
            DrawerHeader(
              decoration: BoxDecoration(color: Colors.teal),
              child: Text(
                'Menu',
                style: TextStyle(color: Colors.white, fontSize: 24),
              ),
            ),

            ListTile(
              leading: Icon(Icons.home_outlined),
              title: Text(
                'Retour à la maison',
                textDirection: TextDirection.rtl,
              ),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MyApp()),
                );
              },
            ),

            Divider(color: Colors.teal),

            ListTile(
              leading: Icon(Icons.cached, color: Colors.blue),
              title: Text('Bleu', textDirection: TextDirection.rtl),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Bleu()),
                );
              },
            ),

            ListTile(
              leading: Icon(Icons.ondemand_video, color: Colors.yellow),
              title: Text('Jaune', textDirection: TextDirection.rtl),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Jaune()),
                );
              },
            ),

            ListTile(
              leading: Icon(Icons.image_search, color: Colors.red),
              title: Text('Rouge', textDirection: TextDirection.rtl),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Rouge()),
                );
              },
            ),

            ListTile(
              leading: Icon(Icons.image, color: Colors.green),
              title: Text('Vert', textDirection: TextDirection.rtl),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Vert()),
                );
              },
            ),

            ListTile(
              leading: Icon(Icons.space_dashboard, color: Colors.deepPurple),
              title: Text('Violet', textDirection: TextDirection.rtl),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Violet()),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}
