function basic(){
  var $wnd_0 = window, $doc_0 = document, $stats = $wnd_0.__gwtStatsEvent?function(a){
    return $wnd_0.__gwtStatsEvent(a);
  }
  :null, $sessionId_0 = $wnd_0.__gwtStatsSessionId?$wnd_0.__gwtStatsSessionId:null, scriptsDone, loadDone, bodyDone, base = '', metaProps = {}, values = [], providers = [], answers = [], softPermutationId = 0, onLoadErrorFunc, propertyErrorFunc;
  $stats && $stats({moduleName:'basic', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'bootstrap', millis:(new Date).getTime(), type:'begin'});
  if (!$wnd_0.__gwt_stylesLoaded) {
    $wnd_0.__gwt_stylesLoaded = {};
  }
  if (!$wnd_0.__gwt_scriptsLoaded) {
    $wnd_0.__gwt_scriptsLoaded = {};
  }
  function isHostedMode(){
    var result = false;
    try {
      var query = $wnd_0.location.search;
      return (query.indexOf('gwt.codesvr=') != -1 || (query.indexOf('gwt.hosted=') != -1 || $wnd_0.external && $wnd_0.external.gwtOnLoad)) && query.indexOf('gwt.hybrid') == -1;
    }
     catch (e) {
    }
    isHostedMode = function(){
      return result;
    }
    ;
    return result;
  }

  function maybeStartModule(){
    if (scriptsDone && loadDone) {
      var iframe = $doc_0.getElementById('basic');
      var frameWnd = iframe.contentWindow;
      if (isHostedMode()) {
        frameWnd.__gwt_getProperty = function(name_0){
          return computePropValue(name_0);
        }
        ;
      }
      basic = null;
      frameWnd.gwtOnLoad(onLoadErrorFunc, 'basic', base, softPermutationId);
      $stats && $stats({moduleName:'basic', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'moduleStartup', millis:(new Date).getTime(), type:'end'});
    }
  }

  function computeScriptBase(){
    function getDirectoryOfFile(path){
      var hashIndex = path.lastIndexOf('#');
      if (hashIndex == -1) {
        hashIndex = path.length;
      }
      var queryIndex = path.indexOf('?');
      if (queryIndex == -1) {
        queryIndex = path.length;
      }
      var slashIndex = path.lastIndexOf('/', Math.min(queryIndex, hashIndex));
      return slashIndex >= 0?path.substring(0, slashIndex + 1):'';
    }

    function ensureAbsoluteUrl(url){
      if (url.match(/^\w+:\/\//)) {
      }
       else {
        var img = $doc_0.createElement('img');
        img.src = url + 'clear.cache.gif';
        url = getDirectoryOfFile(img.src);
      }
      return url;
    }

    function tryMetaTag(){
      var metaVal = __gwt_getMetaProperty('baseUrl');
      if (metaVal != null) {
        return metaVal;
      }
      return '';
    }

    function tryNocacheJsTag(){
      var scriptTags = $doc_0.getElementsByTagName('script');
      for (var i = 0; i < scriptTags.length; ++i) {
        if (scriptTags[i].src.indexOf('basic.nocache.js') != -1) {
          return getDirectoryOfFile(scriptTags[i].src);
        }
      }
      return '';
    }

    function tryMarkerScript(){
      var thisScript;
      if (typeof isBodyLoaded == 'undefined' || !isBodyLoaded()) {
        var markerId = '__gwt_marker_basic';
        var markerScript;
        $doc_0.write('<script id="' + markerId + '"><\/script>');
        markerScript = $doc_0.getElementById(markerId);
        thisScript = markerScript && markerScript.previousSibling;
        while (thisScript && thisScript.tagName != 'SCRIPT') {
          thisScript = thisScript.previousSibling;
        }
        if (markerScript) {
          markerScript.parentNode.removeChild(markerScript);
        }
        if (thisScript && thisScript.src) {
          return getDirectoryOfFile(thisScript.src);
        }
      }
      return '';
    }

    function tryBaseTag(){
      var baseElements = $doc_0.getElementsByTagName('base');
      if (baseElements.length > 0) {
        return baseElements[baseElements.length - 1].href;
      }
      return '';
    }

    var tempBase = tryMetaTag();
    if (tempBase == '') {
      tempBase = tryNocacheJsTag();
    }
    if (tempBase == '') {
      tempBase = tryMarkerScript();
    }
    if (tempBase == '') {
      tempBase = tryBaseTag();
    }
    if (tempBase == '') {
      tempBase = getDirectoryOfFile($doc_0.location.href);
    }
    tempBase = ensureAbsoluteUrl(tempBase);
    base = tempBase;
    return tempBase;
  }

  function processMetas(){
    var metas = document.getElementsByTagName('meta');
    for (var i = 0, n = metas.length; i < n; ++i) {
      var meta = metas[i], name_0 = meta.getAttribute('name'), content_0;
      if (name_0) {
        name_0 = name_0.replace('basic::', '');
        if (name_0.indexOf('::') >= 0) {
          continue;
        }
        if (name_0 == 'gwt:property') {
          content_0 = meta.getAttribute('content');
          if (content_0) {
            var value, eq = content_0.indexOf('=');
            if (eq >= 0) {
              name_0 = content_0.substring(0, eq);
              value = content_0.substring(eq + 1);
            }
             else {
              name_0 = content_0;
              value = '';
            }
            metaProps[name_0] = value;
          }
        }
         else if (name_0 == 'gwt:onPropertyErrorFn') {
          content_0 = meta.getAttribute('content');
          if (content_0) {
            try {
              propertyErrorFunc = eval(content_0);
            }
             catch (e) {
              alert('Bad handler "' + content_0 + '" for "gwt:onPropertyErrorFn"');
            }
          }
        }
         else if (name_0 == 'gwt:onLoadErrorFn') {
          content_0 = meta.getAttribute('content');
          if (content_0) {
            try {
              onLoadErrorFunc = eval(content_0);
            }
             catch (e) {
              alert('Bad handler "' + content_0 + '" for "gwt:onLoadErrorFn"');
            }
          }
        }
      }
    }
  }

  function __gwt_isKnownPropertyValue(propName, propValue){
    return propValue in values[propName];
  }

  function __gwt_getMetaProperty(name_0){
    var value = metaProps[name_0];
    return value == null?null:value;
  }

  function unflattenKeylistIntoAnswers(propValArray, value){
    var answer = answers;
    for (var i = 0, n = propValArray.length - 1; i < n; ++i) {
      answer = answer[propValArray[i]] || (answer[propValArray[i]] = []);
    }
    answer[propValArray[n]] = value;
  }

  function computePropValue(propName){
    var value = providers[propName](), allowedValuesMap = values[propName];
    if (value in allowedValuesMap) {
      return value;
    }
    var allowedValuesList = [];
    for (var k in allowedValuesMap) {
      allowedValuesList[allowedValuesMap[k]] = k;
    }
    if (propertyErrorFunc) {
      propertyErrorFunc(propName, allowedValuesList, value);
    }
    throw null;
  }

  var frameInjected;
  function maybeInjectFrame(){
    if (!frameInjected) {
      frameInjected = true;
      var iframe = $doc_0.createElement('iframe');
      iframe.src = "javascript:''";
      iframe.id = 'basic';
      iframe.style.cssText = 'position:absolute;width:0;height:0;border:none';
      iframe.tabIndex = -1;
      $doc_0.body.appendChild(iframe);
      $stats && $stats({moduleName:'basic', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'moduleStartup', millis:(new Date).getTime(), type:'moduleRequested'});
      iframe.contentWindow.location.replace(base + initialHtml);
    }
  }

  providers['formfactor'] = function(){
    if (typeof console != 'undefined' && typeof console.log != 'undefined') {
      console.log('property-provider name=formfactor');
    }
    var args = location.search;
    var start = args.indexOf('formfactor');
    if (start >= 0) {
      var value = args.substring(start);
      var begin = value.indexOf('=') + 1;
      var end = value.indexOf('&');
      if (end == -1) {
        end = value.length;
      }
      return value.substring(begin, end);
    }
    var ua = navigator.userAgent.toLowerCase();
    if (ua.indexOf('iphone') != -1 || ua.indexOf('ipod') != -1) {
      if (typeof console != 'undefined' && typeof console.log != 'undefined') {
        console.log('formfactor=mobile');
      }
      return 'mobile';
    }
     else if (ua.indexOf('ipad') != -1) {
      if (typeof console != 'undefined' && typeof console.log != 'undefined') {
        console.log('formfactor=tablet');
      }
      return 'tablet';
    }
     else if (ua.indexOf('android') != -1 || ua.indexOf('mobile') != -1) {
      var dpi = 160;
      var width = $wnd_0.screen.width / dpi;
      var height = $wnd_0.screen.height / dpi;
      var size = Math.sqrt(width * width + height * height);
      return size < 6?'mobile':'tablet';
    }
    if (typeof console != 'undefined' && typeof console.log != 'undefined') {
      console.log('formfactor=desktop');
    }
    return 'desktop';
  }
  ;
  values['formfactor'] = {desktop:0, mobile:1, tablet:2};
  providers['gxt.user.agent'] = function(){
    var ua = navigator.userAgent.toLowerCase();
    if (ua.indexOf('chrome') != -1)
      return 'chrome';
    if (ua.indexOf('opera') != -1)
      return 'opera';
    if (ua.indexOf('msie') != -1) {
      if (ua.indexOf('msie 6') != -1)
        return 'ie6';
      if (ua.indexOf('msie 7') != -1)
        return 'ie7';
      if (ua.indexOf('msie 8') != -1)
        return 'ie8';
      return 'ie9';
    }
    if (ua.indexOf('safari') != -1) {
      if (ua.indexOf('version/3') != -1)
        return 'safari3';
      if (ua.indexOf('version/4') != -1)
        return 'safari4';
      return 'safari5';
    }
    if (ua.indexOf('gecko') != -1) {
      if (ua.indexOf('rv:1.8') != -1)
        return 'gecko1_8';
      return 'gecko1_9';
    }
    if (ua.indexOf('adobeair') != -1)
      return 'air';
    return null;
  }
  ;
  values['gxt.user.agent'] = {air:0, chrome:1, gecko1_8:2, gecko1_9:3, ie6:4, ie7:5, ie8:6, ie9:7, opera:8, safari3:9, safari4:10, safari5:11};
  providers['locale'] = function(){
    var locale = null;
    var rtlocale = 'default';
    try {
      if (!locale) {
        var queryParam = location.search;
        var qpStart = queryParam.indexOf('locale=');
        if (qpStart >= 0) {
          var value = queryParam.substring(qpStart + 7);
          var end = queryParam.indexOf('&', qpStart);
          if (end < 0) {
            end = queryParam.length;
          }
          locale = queryParam.substring(qpStart + 7, end);
        }
      }
      if (!locale) {
        locale = __gwt_getMetaProperty('locale');
      }
      if (!locale) {
        locale = $wnd_0['__gwt_Locale'];
      }
      if (locale) {
        rtlocale = locale;
      }
      while (locale && !__gwt_isKnownPropertyValue('locale', locale)) {
        var lastIndex = locale.lastIndexOf('_');
        if (lastIndex < 0) {
          locale = null;
          break;
        }
        locale = locale.substring(0, lastIndex);
      }
    }
     catch (e) {
      alert('Unexpected exception in locale detection, using default: ' + e);
    }
    $wnd_0['__gwt_Locale'] = rtlocale;
    return locale || 'default';
  }
  ;
  values['locale'] = {'default':0, en:1};
  providers['user.agent.os'] = function(){
    var ua = $wnd_0.navigator.userAgent.toLowerCase();
    if (ua.indexOf('macintosh') != -1 || ua.indexOf('mac os x') != -1) {
      return 'mac';
    }
    if (ua.indexOf('linux') != -1) {
      return 'linux';
    }
    if (ua.indexOf('windows') != -1 || ua.indexOf('win32') != -1) {
      return 'windows';
    }
    return 'unknown';
  }
  ;
  values['user.agent.os'] = {linux:0, mac:1, windows:2};
  basic.onScriptLoad = function(){
    if (frameInjected) {
      loadDone = true;
      maybeStartModule();
    }
  }
  ;
  basic.onInjectionDone = function(){
    scriptsDone = true;
    $stats && $stats({moduleName:'basic', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'loadExternalRefs', millis:(new Date).getTime(), type:'end'});
    maybeStartModule();
  }
  ;
  processMetas();
  computeScriptBase();
  var strongName;
  var initialHtml;
  if (isHostedMode()) {
    if ($wnd_0.external && ($wnd_0.external.initModule && $wnd_0.external.initModule('basic'))) {
      $wnd_0.location.reload();
      return;
    }
    initialHtml = 'hosted.html?basic';
    strongName = '';
  }
  $stats && $stats({moduleName:'basic', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'bootstrap', millis:(new Date).getTime(), type:'selectingPermutation'});
  if (!isHostedMode()) {
    try {
      unflattenKeylistIntoAnswers(['desktop', 'ie6', 'default', 'linux'], '18513CA4C4602AD39AF4D8AA1E64B4CB');
      unflattenKeylistIntoAnswers(['desktop', 'ie6', 'default', 'mac'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':1');
      unflattenKeylistIntoAnswers(['mobile', 'ie7', 'default', 'mac'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':10');
      unflattenKeylistIntoAnswers(['mobile', 'ie7', 'default', 'windows'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':11');
      unflattenKeylistIntoAnswers(['tablet', 'ie6', 'default', 'linux'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':12');
      unflattenKeylistIntoAnswers(['tablet', 'ie6', 'default', 'mac'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':13');
      unflattenKeylistIntoAnswers(['tablet', 'ie6', 'default', 'windows'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':14');
      unflattenKeylistIntoAnswers(['tablet', 'ie7', 'default', 'linux'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':15');
      unflattenKeylistIntoAnswers(['tablet', 'ie7', 'default', 'mac'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':16');
      unflattenKeylistIntoAnswers(['tablet', 'ie7', 'default', 'windows'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':17');
      unflattenKeylistIntoAnswers(['desktop', 'ie6', 'default', 'windows'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':2');
      unflattenKeylistIntoAnswers(['desktop', 'ie7', 'default', 'linux'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':3');
      unflattenKeylistIntoAnswers(['desktop', 'ie7', 'default', 'mac'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':4');
      unflattenKeylistIntoAnswers(['desktop', 'ie7', 'default', 'windows'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':5');
      unflattenKeylistIntoAnswers(['mobile', 'ie6', 'default', 'linux'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':6');
      unflattenKeylistIntoAnswers(['mobile', 'ie6', 'default', 'mac'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':7');
      unflattenKeylistIntoAnswers(['mobile', 'ie6', 'default', 'windows'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':8');
      unflattenKeylistIntoAnswers(['mobile', 'ie7', 'default', 'linux'], '18513CA4C4602AD39AF4D8AA1E64B4CB' + ':9');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_8', 'en', 'linux'], '27A2A9DC838296830197910A47936EA6');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_8', 'en', 'mac'], '27A2A9DC838296830197910A47936EA6' + ':1');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_9', 'en', 'mac'], '27A2A9DC838296830197910A47936EA6' + ':10');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_9', 'en', 'windows'], '27A2A9DC838296830197910A47936EA6' + ':11');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_8', 'en', 'linux'], '27A2A9DC838296830197910A47936EA6' + ':12');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_8', 'en', 'mac'], '27A2A9DC838296830197910A47936EA6' + ':13');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_8', 'en', 'windows'], '27A2A9DC838296830197910A47936EA6' + ':14');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_9', 'en', 'linux'], '27A2A9DC838296830197910A47936EA6' + ':15');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_9', 'en', 'mac'], '27A2A9DC838296830197910A47936EA6' + ':16');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_9', 'en', 'windows'], '27A2A9DC838296830197910A47936EA6' + ':17');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_8', 'en', 'windows'], '27A2A9DC838296830197910A47936EA6' + ':2');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_9', 'en', 'linux'], '27A2A9DC838296830197910A47936EA6' + ':3');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_9', 'en', 'mac'], '27A2A9DC838296830197910A47936EA6' + ':4');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_9', 'en', 'windows'], '27A2A9DC838296830197910A47936EA6' + ':5');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_8', 'en', 'linux'], '27A2A9DC838296830197910A47936EA6' + ':6');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_8', 'en', 'mac'], '27A2A9DC838296830197910A47936EA6' + ':7');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_8', 'en', 'windows'], '27A2A9DC838296830197910A47936EA6' + ':8');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_9', 'en', 'linux'], '27A2A9DC838296830197910A47936EA6' + ':9');
      unflattenKeylistIntoAnswers(['desktop', 'ie9', 'default', 'linux'], '46C1188A5EEA42F8675143EC370DC928');
      unflattenKeylistIntoAnswers(['desktop', 'ie9', 'default', 'mac'], '46C1188A5EEA42F8675143EC370DC928' + ':1');
      unflattenKeylistIntoAnswers(['desktop', 'ie9', 'default', 'windows'], '46C1188A5EEA42F8675143EC370DC928' + ':2');
      unflattenKeylistIntoAnswers(['mobile', 'ie9', 'default', 'linux'], '46C1188A5EEA42F8675143EC370DC928' + ':3');
      unflattenKeylistIntoAnswers(['mobile', 'ie9', 'default', 'mac'], '46C1188A5EEA42F8675143EC370DC928' + ':4');
      unflattenKeylistIntoAnswers(['mobile', 'ie9', 'default', 'windows'], '46C1188A5EEA42F8675143EC370DC928' + ':5');
      unflattenKeylistIntoAnswers(['tablet', 'ie9', 'default', 'linux'], '46C1188A5EEA42F8675143EC370DC928' + ':6');
      unflattenKeylistIntoAnswers(['tablet', 'ie9', 'default', 'mac'], '46C1188A5EEA42F8675143EC370DC928' + ':7');
      unflattenKeylistIntoAnswers(['tablet', 'ie9', 'default', 'windows'], '46C1188A5EEA42F8675143EC370DC928' + ':8');
      unflattenKeylistIntoAnswers(['desktop', 'air', 'default', 'linux'], '51232E85A5903A4922B82507489B6053');
      unflattenKeylistIntoAnswers(['desktop', 'air', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':1');
      unflattenKeylistIntoAnswers(['desktop', 'safari4', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':10');
      unflattenKeylistIntoAnswers(['desktop', 'safari4', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':11');
      unflattenKeylistIntoAnswers(['desktop', 'safari5', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':12');
      unflattenKeylistIntoAnswers(['desktop', 'safari5', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':13');
      unflattenKeylistIntoAnswers(['desktop', 'safari5', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':14');
      unflattenKeylistIntoAnswers(['mobile', 'air', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':15');
      unflattenKeylistIntoAnswers(['mobile', 'air', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':16');
      unflattenKeylistIntoAnswers(['mobile', 'air', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':17');
      unflattenKeylistIntoAnswers(['mobile', 'chrome', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':18');
      unflattenKeylistIntoAnswers(['mobile', 'chrome', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':19');
      unflattenKeylistIntoAnswers(['desktop', 'air', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':2');
      unflattenKeylistIntoAnswers(['mobile', 'chrome', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':20');
      unflattenKeylistIntoAnswers(['mobile', 'safari3', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':21');
      unflattenKeylistIntoAnswers(['mobile', 'safari3', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':22');
      unflattenKeylistIntoAnswers(['mobile', 'safari3', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':23');
      unflattenKeylistIntoAnswers(['mobile', 'safari4', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':24');
      unflattenKeylistIntoAnswers(['mobile', 'safari4', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':25');
      unflattenKeylistIntoAnswers(['mobile', 'safari4', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':26');
      unflattenKeylistIntoAnswers(['mobile', 'safari5', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':27');
      unflattenKeylistIntoAnswers(['mobile', 'safari5', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':28');
      unflattenKeylistIntoAnswers(['mobile', 'safari5', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':29');
      unflattenKeylistIntoAnswers(['desktop', 'chrome', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':3');
      unflattenKeylistIntoAnswers(['tablet', 'air', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':30');
      unflattenKeylistIntoAnswers(['tablet', 'air', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':31');
      unflattenKeylistIntoAnswers(['tablet', 'air', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':32');
      unflattenKeylistIntoAnswers(['tablet', 'chrome', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':33');
      unflattenKeylistIntoAnswers(['tablet', 'chrome', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':34');
      unflattenKeylistIntoAnswers(['tablet', 'chrome', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':35');
      unflattenKeylistIntoAnswers(['tablet', 'safari3', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':36');
      unflattenKeylistIntoAnswers(['tablet', 'safari3', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':37');
      unflattenKeylistIntoAnswers(['tablet', 'safari3', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':38');
      unflattenKeylistIntoAnswers(['tablet', 'safari4', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':39');
      unflattenKeylistIntoAnswers(['desktop', 'chrome', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':4');
      unflattenKeylistIntoAnswers(['tablet', 'safari4', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':40');
      unflattenKeylistIntoAnswers(['tablet', 'safari4', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':41');
      unflattenKeylistIntoAnswers(['tablet', 'safari5', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':42');
      unflattenKeylistIntoAnswers(['tablet', 'safari5', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':43');
      unflattenKeylistIntoAnswers(['tablet', 'safari5', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':44');
      unflattenKeylistIntoAnswers(['desktop', 'chrome', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':5');
      unflattenKeylistIntoAnswers(['desktop', 'safari3', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':6');
      unflattenKeylistIntoAnswers(['desktop', 'safari3', 'default', 'mac'], '51232E85A5903A4922B82507489B6053' + ':7');
      unflattenKeylistIntoAnswers(['desktop', 'safari3', 'default', 'windows'], '51232E85A5903A4922B82507489B6053' + ':8');
      unflattenKeylistIntoAnswers(['desktop', 'safari4', 'default', 'linux'], '51232E85A5903A4922B82507489B6053' + ':9');
      unflattenKeylistIntoAnswers(['desktop', 'ie9', 'en', 'linux'], '5441AFBED0B7C65F1FB9D5581CD8286B');
      unflattenKeylistIntoAnswers(['desktop', 'ie9', 'en', 'mac'], '5441AFBED0B7C65F1FB9D5581CD8286B' + ':1');
      unflattenKeylistIntoAnswers(['desktop', 'ie9', 'en', 'windows'], '5441AFBED0B7C65F1FB9D5581CD8286B' + ':2');
      unflattenKeylistIntoAnswers(['mobile', 'ie9', 'en', 'linux'], '5441AFBED0B7C65F1FB9D5581CD8286B' + ':3');
      unflattenKeylistIntoAnswers(['mobile', 'ie9', 'en', 'mac'], '5441AFBED0B7C65F1FB9D5581CD8286B' + ':4');
      unflattenKeylistIntoAnswers(['mobile', 'ie9', 'en', 'windows'], '5441AFBED0B7C65F1FB9D5581CD8286B' + ':5');
      unflattenKeylistIntoAnswers(['tablet', 'ie9', 'en', 'linux'], '5441AFBED0B7C65F1FB9D5581CD8286B' + ':6');
      unflattenKeylistIntoAnswers(['tablet', 'ie9', 'en', 'mac'], '5441AFBED0B7C65F1FB9D5581CD8286B' + ':7');
      unflattenKeylistIntoAnswers(['tablet', 'ie9', 'en', 'windows'], '5441AFBED0B7C65F1FB9D5581CD8286B' + ':8');
      unflattenKeylistIntoAnswers(['desktop', 'opera', 'en', 'linux'], '64FD44D0809CA0E67C0F4F6E79079125');
      unflattenKeylistIntoAnswers(['desktop', 'opera', 'en', 'mac'], '64FD44D0809CA0E67C0F4F6E79079125' + ':1');
      unflattenKeylistIntoAnswers(['desktop', 'opera', 'en', 'windows'], '64FD44D0809CA0E67C0F4F6E79079125' + ':2');
      unflattenKeylistIntoAnswers(['mobile', 'opera', 'en', 'linux'], '64FD44D0809CA0E67C0F4F6E79079125' + ':3');
      unflattenKeylistIntoAnswers(['mobile', 'opera', 'en', 'mac'], '64FD44D0809CA0E67C0F4F6E79079125' + ':4');
      unflattenKeylistIntoAnswers(['mobile', 'opera', 'en', 'windows'], '64FD44D0809CA0E67C0F4F6E79079125' + ':5');
      unflattenKeylistIntoAnswers(['tablet', 'opera', 'en', 'linux'], '64FD44D0809CA0E67C0F4F6E79079125' + ':6');
      unflattenKeylistIntoAnswers(['tablet', 'opera', 'en', 'mac'], '64FD44D0809CA0E67C0F4F6E79079125' + ':7');
      unflattenKeylistIntoAnswers(['tablet', 'opera', 'en', 'windows'], '64FD44D0809CA0E67C0F4F6E79079125' + ':8');
      unflattenKeylistIntoAnswers(['desktop', 'air', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0');
      unflattenKeylistIntoAnswers(['desktop', 'air', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':1');
      unflattenKeylistIntoAnswers(['desktop', 'safari4', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':10');
      unflattenKeylistIntoAnswers(['desktop', 'safari4', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':11');
      unflattenKeylistIntoAnswers(['desktop', 'safari5', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':12');
      unflattenKeylistIntoAnswers(['desktop', 'safari5', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':13');
      unflattenKeylistIntoAnswers(['desktop', 'safari5', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':14');
      unflattenKeylistIntoAnswers(['mobile', 'air', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':15');
      unflattenKeylistIntoAnswers(['mobile', 'air', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':16');
      unflattenKeylistIntoAnswers(['mobile', 'air', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':17');
      unflattenKeylistIntoAnswers(['mobile', 'chrome', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':18');
      unflattenKeylistIntoAnswers(['mobile', 'chrome', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':19');
      unflattenKeylistIntoAnswers(['desktop', 'air', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':2');
      unflattenKeylistIntoAnswers(['mobile', 'chrome', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':20');
      unflattenKeylistIntoAnswers(['mobile', 'safari3', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':21');
      unflattenKeylistIntoAnswers(['mobile', 'safari3', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':22');
      unflattenKeylistIntoAnswers(['mobile', 'safari3', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':23');
      unflattenKeylistIntoAnswers(['mobile', 'safari4', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':24');
      unflattenKeylistIntoAnswers(['mobile', 'safari4', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':25');
      unflattenKeylistIntoAnswers(['mobile', 'safari4', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':26');
      unflattenKeylistIntoAnswers(['mobile', 'safari5', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':27');
      unflattenKeylistIntoAnswers(['mobile', 'safari5', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':28');
      unflattenKeylistIntoAnswers(['mobile', 'safari5', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':29');
      unflattenKeylistIntoAnswers(['desktop', 'chrome', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':3');
      unflattenKeylistIntoAnswers(['tablet', 'air', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':30');
      unflattenKeylistIntoAnswers(['tablet', 'air', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':31');
      unflattenKeylistIntoAnswers(['tablet', 'air', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':32');
      unflattenKeylistIntoAnswers(['tablet', 'chrome', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':33');
      unflattenKeylistIntoAnswers(['tablet', 'chrome', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':34');
      unflattenKeylistIntoAnswers(['tablet', 'chrome', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':35');
      unflattenKeylistIntoAnswers(['tablet', 'safari3', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':36');
      unflattenKeylistIntoAnswers(['tablet', 'safari3', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':37');
      unflattenKeylistIntoAnswers(['tablet', 'safari3', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':38');
      unflattenKeylistIntoAnswers(['tablet', 'safari4', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':39');
      unflattenKeylistIntoAnswers(['desktop', 'chrome', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':4');
      unflattenKeylistIntoAnswers(['tablet', 'safari4', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':40');
      unflattenKeylistIntoAnswers(['tablet', 'safari4', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':41');
      unflattenKeylistIntoAnswers(['tablet', 'safari5', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':42');
      unflattenKeylistIntoAnswers(['tablet', 'safari5', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':43');
      unflattenKeylistIntoAnswers(['tablet', 'safari5', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':44');
      unflattenKeylistIntoAnswers(['desktop', 'chrome', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':5');
      unflattenKeylistIntoAnswers(['desktop', 'safari3', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':6');
      unflattenKeylistIntoAnswers(['desktop', 'safari3', 'en', 'mac'], '78927E2D41E202641A7E23AF34C130B0' + ':7');
      unflattenKeylistIntoAnswers(['desktop', 'safari3', 'en', 'windows'], '78927E2D41E202641A7E23AF34C130B0' + ':8');
      unflattenKeylistIntoAnswers(['desktop', 'safari4', 'en', 'linux'], '78927E2D41E202641A7E23AF34C130B0' + ':9');
      unflattenKeylistIntoAnswers(['desktop', 'ie8', 'en', 'linux'], '7CFE828D78035647D559D57880174DB8');
      unflattenKeylistIntoAnswers(['desktop', 'ie8', 'en', 'mac'], '7CFE828D78035647D559D57880174DB8' + ':1');
      unflattenKeylistIntoAnswers(['desktop', 'ie8', 'en', 'windows'], '7CFE828D78035647D559D57880174DB8' + ':2');
      unflattenKeylistIntoAnswers(['mobile', 'ie8', 'en', 'linux'], '7CFE828D78035647D559D57880174DB8' + ':3');
      unflattenKeylistIntoAnswers(['mobile', 'ie8', 'en', 'mac'], '7CFE828D78035647D559D57880174DB8' + ':4');
      unflattenKeylistIntoAnswers(['mobile', 'ie8', 'en', 'windows'], '7CFE828D78035647D559D57880174DB8' + ':5');
      unflattenKeylistIntoAnswers(['tablet', 'ie8', 'en', 'linux'], '7CFE828D78035647D559D57880174DB8' + ':6');
      unflattenKeylistIntoAnswers(['tablet', 'ie8', 'en', 'mac'], '7CFE828D78035647D559D57880174DB8' + ':7');
      unflattenKeylistIntoAnswers(['tablet', 'ie8', 'en', 'windows'], '7CFE828D78035647D559D57880174DB8' + ':8');
      unflattenKeylistIntoAnswers(['desktop', 'opera', 'default', 'linux'], '83C6BF726A4E3678BCFE46E8D0DDEA1B');
      unflattenKeylistIntoAnswers(['desktop', 'opera', 'default', 'mac'], '83C6BF726A4E3678BCFE46E8D0DDEA1B' + ':1');
      unflattenKeylistIntoAnswers(['desktop', 'opera', 'default', 'windows'], '83C6BF726A4E3678BCFE46E8D0DDEA1B' + ':2');
      unflattenKeylistIntoAnswers(['mobile', 'opera', 'default', 'linux'], '83C6BF726A4E3678BCFE46E8D0DDEA1B' + ':3');
      unflattenKeylistIntoAnswers(['mobile', 'opera', 'default', 'mac'], '83C6BF726A4E3678BCFE46E8D0DDEA1B' + ':4');
      unflattenKeylistIntoAnswers(['mobile', 'opera', 'default', 'windows'], '83C6BF726A4E3678BCFE46E8D0DDEA1B' + ':5');
      unflattenKeylistIntoAnswers(['tablet', 'opera', 'default', 'linux'], '83C6BF726A4E3678BCFE46E8D0DDEA1B' + ':6');
      unflattenKeylistIntoAnswers(['tablet', 'opera', 'default', 'mac'], '83C6BF726A4E3678BCFE46E8D0DDEA1B' + ':7');
      unflattenKeylistIntoAnswers(['tablet', 'opera', 'default', 'windows'], '83C6BF726A4E3678BCFE46E8D0DDEA1B' + ':8');
      unflattenKeylistIntoAnswers(['desktop', 'ie8', 'default', 'linux'], 'B7BD846C69C94A090F303FDA051D0200');
      unflattenKeylistIntoAnswers(['desktop', 'ie8', 'default', 'mac'], 'B7BD846C69C94A090F303FDA051D0200' + ':1');
      unflattenKeylistIntoAnswers(['desktop', 'ie8', 'default', 'windows'], 'B7BD846C69C94A090F303FDA051D0200' + ':2');
      unflattenKeylistIntoAnswers(['mobile', 'ie8', 'default', 'linux'], 'B7BD846C69C94A090F303FDA051D0200' + ':3');
      unflattenKeylistIntoAnswers(['mobile', 'ie8', 'default', 'mac'], 'B7BD846C69C94A090F303FDA051D0200' + ':4');
      unflattenKeylistIntoAnswers(['mobile', 'ie8', 'default', 'windows'], 'B7BD846C69C94A090F303FDA051D0200' + ':5');
      unflattenKeylistIntoAnswers(['tablet', 'ie8', 'default', 'linux'], 'B7BD846C69C94A090F303FDA051D0200' + ':6');
      unflattenKeylistIntoAnswers(['tablet', 'ie8', 'default', 'mac'], 'B7BD846C69C94A090F303FDA051D0200' + ':7');
      unflattenKeylistIntoAnswers(['tablet', 'ie8', 'default', 'windows'], 'B7BD846C69C94A090F303FDA051D0200' + ':8');
      unflattenKeylistIntoAnswers(['desktop', 'ie6', 'en', 'linux'], 'D5EB3B2FCA1948479FAB1D62205FC09C');
      unflattenKeylistIntoAnswers(['desktop', 'ie6', 'en', 'mac'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':1');
      unflattenKeylistIntoAnswers(['mobile', 'ie7', 'en', 'mac'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':10');
      unflattenKeylistIntoAnswers(['mobile', 'ie7', 'en', 'windows'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':11');
      unflattenKeylistIntoAnswers(['tablet', 'ie6', 'en', 'linux'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':12');
      unflattenKeylistIntoAnswers(['tablet', 'ie6', 'en', 'mac'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':13');
      unflattenKeylistIntoAnswers(['tablet', 'ie6', 'en', 'windows'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':14');
      unflattenKeylistIntoAnswers(['tablet', 'ie7', 'en', 'linux'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':15');
      unflattenKeylistIntoAnswers(['tablet', 'ie7', 'en', 'mac'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':16');
      unflattenKeylistIntoAnswers(['tablet', 'ie7', 'en', 'windows'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':17');
      unflattenKeylistIntoAnswers(['desktop', 'ie6', 'en', 'windows'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':2');
      unflattenKeylistIntoAnswers(['desktop', 'ie7', 'en', 'linux'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':3');
      unflattenKeylistIntoAnswers(['desktop', 'ie7', 'en', 'mac'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':4');
      unflattenKeylistIntoAnswers(['desktop', 'ie7', 'en', 'windows'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':5');
      unflattenKeylistIntoAnswers(['mobile', 'ie6', 'en', 'linux'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':6');
      unflattenKeylistIntoAnswers(['mobile', 'ie6', 'en', 'mac'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':7');
      unflattenKeylistIntoAnswers(['mobile', 'ie6', 'en', 'windows'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':8');
      unflattenKeylistIntoAnswers(['mobile', 'ie7', 'en', 'linux'], 'D5EB3B2FCA1948479FAB1D62205FC09C' + ':9');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_8', 'default', 'linux'], 'FD5F062931AE5AE5E1D7E4290764A57E');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_8', 'default', 'mac'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':1');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_9', 'default', 'mac'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':10');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_9', 'default', 'windows'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':11');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_8', 'default', 'linux'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':12');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_8', 'default', 'mac'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':13');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_8', 'default', 'windows'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':14');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_9', 'default', 'linux'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':15');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_9', 'default', 'mac'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':16');
      unflattenKeylistIntoAnswers(['tablet', 'gecko1_9', 'default', 'windows'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':17');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_8', 'default', 'windows'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':2');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_9', 'default', 'linux'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':3');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_9', 'default', 'mac'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':4');
      unflattenKeylistIntoAnswers(['desktop', 'gecko1_9', 'default', 'windows'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':5');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_8', 'default', 'linux'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':6');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_8', 'default', 'mac'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':7');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_8', 'default', 'windows'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':8');
      unflattenKeylistIntoAnswers(['mobile', 'gecko1_9', 'default', 'linux'], 'FD5F062931AE5AE5E1D7E4290764A57E' + ':9');
      strongName = answers[computePropValue('formfactor')][computePropValue('gxt.user.agent')][computePropValue('locale')][computePropValue('user.agent.os')];
      var idx = strongName.indexOf(':');
      if (idx != -1) {
        softPermutationId = Number(strongName.substring(idx + 1));
        strongName = strongName.substring(0, idx);
      }
      initialHtml = strongName + '.cache.html';
    }
     catch (e) {
      return;
    }
  }
  var onBodyDoneTimerId;
  function onBodyDone(){
    if (!bodyDone) {
      bodyDone = true;
      maybeStartModule();
      if ($doc_0.removeEventListener) {
        $doc_0.removeEventListener('DOMContentLoaded', onBodyDone, false);
      }
      if (onBodyDoneTimerId) {
        clearInterval(onBodyDoneTimerId);
      }
    }
  }

  if ($doc_0.addEventListener) {
    $doc_0.addEventListener('DOMContentLoaded', function(){
      maybeInjectFrame();
      onBodyDone();
    }
    , false);
  }
  var onBodyDoneTimerId = setInterval(function(){
    if (/loaded|complete/.test($doc_0.readyState)) {
      maybeInjectFrame();
      onBodyDone();
    }
  }
  , 50);
  $stats && $stats({moduleName:'basic', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'bootstrap', millis:(new Date).getTime(), type:'end'});
  $stats && $stats({moduleName:'basic', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'loadExternalRefs', millis:(new Date).getTime(), type:'begin'});
  if (!__gwt_scriptsLoaded['gwtcx/thirdparty/base64.js']) {
    __gwt_scriptsLoaded['gwtcx/thirdparty/base64.js'] = true;
    document.write('<script language="javascript" src="' + base + 'gwtcx/thirdparty/base64.js"><\/script>');
  }
  $doc_0.write('<script defer="defer">basic.onInjectionDone(\'basic\')<\/script>');
}

basic();
