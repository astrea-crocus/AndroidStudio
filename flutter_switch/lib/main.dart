import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyApp createState() => _MyApp();
}

class _MyApp extends State<MyApp> {
  ThemeMode _themeMode = ThemeMode.light;

  void _changeTheme(bool isDarkMode) {
    setState(() {
      _themeMode = isDarkMode ? ThemeMode.dark : ThemeMode.light;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Switch Theme',
      theme: ThemeData.light(),
      darkTheme: ThemeData.dark(),
      themeMode: _themeMode,
      home: ThemeSwitcherPage(changeTheme: _changeTheme),
    );
  }
}

class ThemeSwitcherPage extends StatefulWidget {
  final Function(bool) changeTheme;

  const ThemeSwitcherPage({super.key, required this.changeTheme});

  @override
  _ThemeSwitcherPageState createState() => _ThemeSwitcherPageState();
}

class _ThemeSwitcherPageState extends State<ThemeSwitcherPage> {
  bool _isDarkMode = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Changer de thème Zoom'),

        flexibleSpace: ShaderMask(
          shaderCallback:
              (bounds) => LinearGradient(
                begin: Alignment.topCenter,
                end: Alignment.bottomCenter,
                colors: [
                  Colors.black.withValues(alpha: 0.2),
                  Colors.white.withValues(alpha: 0.2),
                ],
              ).createShader(bounds),
          blendMode: BlendMode.softLight,
          child: Container(color: Theme.of(context).primaryColor),
        ),
      ),

      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: Icon(Icons.arrow_back),
      ),

      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              _isDarkMode ? 'Dark Mode' : 'Light Mode',
              style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 20),
            SwitchListTile(
              title: Text(
                  _isDarkMode ? 'Activer Light Mode' : 'Activer Dark Mode'
              ),
              value: _isDarkMode,
              onChanged: (bool value) {
                setState(() {
                  _isDarkMode = value;
                });
                widget.changeTheme(value);
              },
              secondary: Icon(_isDarkMode ? Icons.dark_mode : Icons.light_mode),
            ),
            SizedBox(height: 40),
            Container(
              padding: EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: Theme.of(context).cardColor,
                borderRadius: BorderRadius.circular(10),
                boxShadow: [
                  BoxShadow(
                    color: Colors.black.withAlpha(128),
                    blurRadius: 5,
                    spreadRadius: 1,
                  ),
                ],
              ),
              child: Text('Contenu du reste de l\'Apps'),
            ),
          ],
        ),
      ),
    );
  }
}
