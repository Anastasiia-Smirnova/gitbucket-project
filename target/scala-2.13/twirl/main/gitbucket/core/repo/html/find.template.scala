
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object find extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  treeId: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo
  )(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main(s"${repository.owner}/${repository.name}", Some(repository))/*6.87*/ {_display_(Seq[Any](format.raw/*6.89*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("files", repository, Some(branch))/*7.63*/{_display_(Seq[Any](format.raw/*7.64*/("""

"""),format.raw/*9.1*/("""<div>
  <div class="find-input">
    <span class="bold"><a href=""""),_display_(/*11.34*/helpers/*11.41*/.url(repository)),format.raw/*11.57*/("""/tree/"""),_display_(/*11.64*/helpers/*11.71*/.encodeRefName(branch)),format.raw/*11.93*/("""">"""),_display_(/*11.96*/repository/*11.106*/.name),format.raw/*11.111*/("""</a></span>
    /
    <input type="text" name="query" class="form-control" style="display: inline; width: 300px;" autocomplete="off" spellcheck="false" autofocus id="tree-finder-field" aria-label="query"/>
  </div>
</div>

<div class="alert alert-info">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  You've activated the <em>file finder</em>
  by pressing <code>t</code>.
  Start typing to filter the file list. Use <code>↑</code> and
  <code>↓</code> to navigate,
  <code>enter</code> to view files.
</div>
<table id="tree-finder-results" class="table table-file-list" data-url=""""),_display_(/*25.74*/helpers/*25.81*/.url(repository)),format.raw/*25.97*/("""/tree-list/"""),_display_(/*25.109*/treeId),format.raw/*25.115*/("""">
  <tbody class="tree-browser-result-template">
    <tr class="tree-browser-result">
      <td class="icon"><span class="octicon octicon-chevron-right"></span></td>
      <td class="icon"><i class="octicon octicon-file-text"></i></td>
      <td>
        <a href=""""),_display_(/*31.19*/helpers/*31.26*/.url(repository)),format.raw/*31.42*/("""/blob/"""),_display_(/*31.49*/helpers/*31.56*/.encodeRefName(branch)),format.raw/*31.78*/(""""></a>
      </td>
    </tr>
  </tbody>
  <tbody class="no-results" style="display:none">
    <tr><th colspan="3">No matching files</th><tr>
  </tbody>
</table>
<script>
$(function()"""),format.raw/*40.13*/("""{"""),format.raw/*40.14*/("""
  """),format.raw/*41.3*/("""var paths = [];
  var template = $('.tree-browser-result-template tr').clone();
  var res = $('.tree-browser-result-template');
  var cursor = 0;
  var pathBase = template.find("a").attr("href");
  var preKeyword;
  $.ajax("""),format.raw/*47.10*/("""{"""),format.raw/*47.11*/("""
    """),format.raw/*48.5*/("""url:$('#tree-finder-results').data('url'),
    cache: true,
    dataType: 'json',
    success:function(data)"""),format.raw/*51.27*/("""{"""),format.raw/*51.28*/("""
      """),format.raw/*52.7*/("""paths = data.paths;
      filter();
    """),format.raw/*54.5*/("""}"""),format.raw/*54.6*/("""
  """),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""");
  var timer;
  $("#tree-finder-field").keydown(function(e)"""),format.raw/*57.46*/("""{"""),format.raw/*57.47*/("""
    """),format.raw/*58.5*/("""var target = $(this);
    if(e.keyCode == 40)"""),format.raw/*59.24*/("""{"""),format.raw/*59.25*/(""" """),format.raw/*59.26*/("""// DOWN
      e.preventDefault();
      e.stopPropagation();
      changeCursor(cursor + 1);
    """),format.raw/*63.5*/("""}"""),format.raw/*63.6*/(""" """),format.raw/*63.7*/("""else if(e.keyCode == 38)"""),format.raw/*63.31*/("""{"""),format.raw/*63.32*/(""" """),format.raw/*63.33*/("""// UP
      e.preventDefault();
      e.stopPropagation();
      changeCursor(cursor - 1);
    """),format.raw/*67.5*/("""}"""),format.raw/*67.6*/(""" """),format.raw/*67.7*/("""else if(e.keyCode == 13)"""),format.raw/*67.31*/("""{"""),format.raw/*67.32*/(""" """),format.raw/*67.33*/("""// ENTER
      e.preventDefault();
      e.stopPropagation();
      target = $(".tree-browser-result.navigation-focus a");
      if(target[0])"""),format.raw/*71.20*/("""{"""),format.raw/*71.21*/("""
        """),format.raw/*72.9*/("""target[0].click();
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/("""
    """),format.raw/*74.5*/("""}"""),format.raw/*74.6*/(""" """),format.raw/*74.7*/("""else if(e.keyCode == 27)"""),format.raw/*74.31*/("""{"""),format.raw/*74.32*/(""" """),format.raw/*74.33*/("""// ESC
      e.preventDefault();
      e.stopPropagation();
      history.back();
    """),format.raw/*78.5*/("""}"""),format.raw/*78.6*/(""" """),format.raw/*78.7*/("""else """),format.raw/*78.12*/("""{"""),format.raw/*78.13*/("""
      """),format.raw/*79.7*/("""clearTimeout(timer);
      timer = setTimeout(filter,300);
    """),format.raw/*81.5*/("""}"""),format.raw/*81.6*/("""
  """),format.raw/*82.3*/("""}"""),format.raw/*82.4*/(""");
  function changeCursor(newPos)"""),format.raw/*83.32*/("""{"""),format.raw/*83.33*/("""
    """),format.raw/*84.5*/("""if(!$(".tree-browser-result")[newPos])"""),format.raw/*84.43*/("""{"""),format.raw/*84.44*/("""
      """),format.raw/*85.7*/("""return $(".tree-browser-result.navigation-focus");
    """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/("""
    """),format.raw/*87.5*/("""$(".tree-browser-result.navigation-focus").removeClass("navigation-focus");
    cursor=newPos;
    scrollIntoView($($(".tree-browser-result")[cursor]).addClass("navigation-focus"));
  """),format.raw/*90.3*/("""}"""),format.raw/*90.4*/("""
  """),format.raw/*91.3*/("""function filter()"""),format.raw/*91.20*/("""{"""),format.raw/*91.21*/("""
    """),format.raw/*92.5*/("""var v = $('#tree-finder-field').val();
    if(v == preKeyword || paths.length == 0)"""),format.raw/*93.45*/("""{"""),format.raw/*93.46*/("""
      """),format.raw/*94.7*/("""return;
    """),format.raw/*95.5*/("""}"""),format.raw/*95.6*/("""
    """),format.raw/*96.5*/("""scrollIntoView('#tree-finder-field');
    preKeyword = v;
    cursor = 0;
    var p = string_score_sort(v, paths, 50);
    res.html("");
    if(p.length == 0)"""),format.raw/*101.22*/("""{"""),format.raw/*101.23*/("""
      """),format.raw/*102.7*/("""$(".no-results").show();
      return;
    """),format.raw/*104.5*/("""}"""),format.raw/*104.6*/(""" """),format.raw/*104.7*/("""else """),format.raw/*104.12*/("""{"""),format.raw/*104.13*/("""
      """),format.raw/*105.7*/("""$(".no-results").hide();
      for(var i = 0; i < p.length; i++)"""),format.raw/*106.40*/("""{"""),format.raw/*106.41*/("""
        """),format.raw/*107.9*/("""var row = template.clone();
        row.find("a").attr("href", pathBase + "/" + encodeURIComponent(p[i].string).replace(/%2F/g, '/')).html(string_score_highlight(p[i], '<b>'));
        if(cursor == i)"""),format.raw/*109.24*/("""{"""),format.raw/*109.25*/("""
          """),format.raw/*110.11*/("""row.addClass("navigation-focus");
        """),format.raw/*111.9*/("""}"""),format.raw/*111.10*/("""
        """),format.raw/*112.9*/("""row.appendTo(res);
      """),format.raw/*113.7*/("""}"""),format.raw/*113.8*/("""
    """),format.raw/*114.5*/("""}"""),format.raw/*114.6*/("""
  """),format.raw/*115.3*/("""}"""),format.raw/*115.4*/("""
"""),format.raw/*116.1*/("""}"""),format.raw/*116.2*/(""");
</script>
  """)))}),format.raw/*118.4*/("""
""")))}),format.raw/*119.2*/("""
"""))
      }
    }
  }

  def render(branch:String,treeId:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,treeId,repository)(context)

  def f:((String,String,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,treeId,repository) => (context) => apply(branch,treeId,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/find.scala.html
                  HASH: 2e0297d264e983c6163c8bdba2074719b5e4d8e7
                  MATRIX: 676->1|910->164|973->200|990->209|1074->285|1113->287|1142->291|1159->300|1217->350|1255->351|1283->353|1376->419|1392->426|1429->442|1463->449|1479->456|1522->478|1552->481|1572->491|1599->496|2239->1109|2255->1116|2292->1132|2332->1144|2360->1150|2653->1416|2669->1423|2706->1439|2740->1446|2756->1453|2799->1475|3009->1657|3038->1658|3068->1661|3319->1884|3348->1885|3380->1890|3516->1998|3545->1999|3579->2006|3646->2046|3674->2047|3704->2050|3732->2051|3821->2112|3850->2113|3882->2118|3955->2163|3984->2164|4013->2165|4137->2262|4165->2263|4193->2264|4245->2288|4274->2289|4303->2290|4425->2385|4453->2386|4481->2387|4533->2411|4562->2412|4591->2413|4761->2555|4790->2556|4826->2565|4878->2590|4906->2591|4938->2596|4966->2597|4994->2598|5046->2622|5075->2623|5104->2624|5217->2710|5245->2711|5273->2712|5306->2717|5335->2718|5369->2725|5459->2788|5487->2789|5517->2792|5545->2793|5607->2827|5636->2828|5668->2833|5734->2871|5763->2872|5797->2879|5879->2934|5907->2935|5939->2940|6150->3124|6178->3125|6208->3128|6253->3145|6282->3146|6314->3151|6425->3234|6454->3235|6488->3242|6527->3254|6555->3255|6587->3260|6774->3418|6804->3419|6839->3426|6910->3469|6939->3470|6968->3471|7002->3476|7032->3477|7067->3484|7160->3548|7190->3549|7227->3558|7456->3758|7486->3759|7526->3770|7596->3812|7626->3813|7663->3822|7716->3847|7745->3848|7778->3853|7807->3854|7838->3857|7867->3858|7896->3859|7925->3860|7972->3876|8005->3878
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|26->9|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|42->25|42->25|42->25|42->25|42->25|48->31|48->31|48->31|48->31|48->31|48->31|57->40|57->40|58->41|64->47|64->47|65->48|68->51|68->51|69->52|71->54|71->54|72->55|72->55|74->57|74->57|75->58|76->59|76->59|76->59|80->63|80->63|80->63|80->63|80->63|80->63|84->67|84->67|84->67|84->67|84->67|84->67|88->71|88->71|89->72|90->73|90->73|91->74|91->74|91->74|91->74|91->74|91->74|95->78|95->78|95->78|95->78|95->78|96->79|98->81|98->81|99->82|99->82|100->83|100->83|101->84|101->84|101->84|102->85|103->86|103->86|104->87|107->90|107->90|108->91|108->91|108->91|109->92|110->93|110->93|111->94|112->95|112->95|113->96|118->101|118->101|119->102|121->104|121->104|121->104|121->104|121->104|122->105|123->106|123->106|124->107|126->109|126->109|127->110|128->111|128->111|129->112|130->113|130->113|131->114|131->114|132->115|132->115|133->116|133->116|135->118|136->119
                  -- GENERATED --
              */
          