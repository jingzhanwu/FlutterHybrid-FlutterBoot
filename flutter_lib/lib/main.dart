import 'package:flutter/material.dart';
import 'package:flutter_lib/flutter_boost_app.dart';
import 'package:flutter_lib/widgets/page_widgets.dart';

void main() => runApp(MyFlutterBoostApp({
      'embeded': (pageName, params, String id) => EmbededFirstRouteWidget(),
      'first': (pageName, params, String id) => FirstRouteWidget(),
      'second': (pageName, params, String id) => SecondRouteWidget(),
      'tab': (pageName, params, String id) => TabRouteWidget(),
      'platformView': (pageName, params, String id) => PlatformRouteWidget(),
      'flutterDemoPage': (String url, Map params, String id) =>
          MyHomePage(title: '$url $id'),
      'flutterPage': (String pageName, Map params, String id) =>
          FlutterRouteWidget(params: params),
      'flutterFragment': (String url, Map params, String id) =>
          FragmentRouteWidget(params),
    }));

// void main() => runApp(MaterialApp(
//       title: "MyApp",
//       home: MyHomePage(
//         title: "计数器",
//         key: const ValueKey('myTitle'),
//       ),
//     ));
