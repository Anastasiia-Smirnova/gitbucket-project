
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object branchcontrol extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String  = "",
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*5.2*/gitbucket/*5.11*/.core.helper.html.dropdown(
  value  = if(branch.length == 40) branch.substring(0, 10) else branch,
  prefix = if(repository.branchList.contains(branch)) "branch" else if (repository.tags.map(_.name).contains(branch)) "tag" else "tree",
  maxValueWidth = "200px"
)/*9.2*/ {_display_(Seq[Any](format.raw/*9.4*/("""
  """),format.raw/*10.3*/("""<li>
    <ul class="nav nav-tabs">
      <li class="active" id="branch-control-tab-branches"><a href="javascript:void(0);" class="nav-item" id="nav-item-branches">Branches</a></li>
      <li id="branch-control-tab-tags"><a href="javascript:void(0);" class="nav-item" id="nav-item-tags">Tags</a></li>
      <li><button id="branch-control-close" class="pull-right">&times</button></li>
    </ul>
    <li>
      <input id="branch-control-input" type="text" class="form-control input-sm dropdown-filter-input"/>
    </li>
    """),_display_(/*19.6*/body),format.raw/*19.10*/("""
    """),_display_(if(hasWritePermission)/*20.28*/ {_display_(Seq[Any](format.raw/*20.30*/("""
      """),format.raw/*21.7*/("""<li id="create-branch" style="display: none;">
        <a><form action=""""),_display_(/*22.27*/helpers/*22.34*/.url(repository)),format.raw/*22.50*/("""/branches" method="post" style="margin: 0;">
          <span class="strong">Create branch:&nbsp;<span class="new-branch"></span></span>
          <br><span style="padding-left: 17px;">from&nbsp;'"""),_display_(/*24.61*/branch),format.raw/*24.67*/("""'</span>
          <input type="hidden" name="new">
          <input type="hidden" name="from" value=""""),_display_(/*26.52*/branch),format.raw/*26.58*/("""">
        </form></a>
      </li>
    """)))} else {null} ),format.raw/*29.6*/("""
  """),format.raw/*30.3*/("""</li>
""")))}),format.raw/*31.2*/("""
"""),format.raw/*32.1*/("""<script>
  $(function()"""),format.raw/*33.15*/("""{"""),format.raw/*33.16*/("""
    """),format.raw/*34.5*/("""$('#branch-control-input').parent().click(function(e) """),format.raw/*34.59*/("""{"""),format.raw/*34.60*/("""
      """),format.raw/*35.7*/("""e.stopPropagation();
    """),format.raw/*36.5*/("""}"""),format.raw/*36.6*/(""");

    $('#branch-control-close').click(function() """),format.raw/*38.49*/("""{"""),format.raw/*38.50*/("""
      """),format.raw/*39.7*/("""$('[data-toggle="dropdown"]').parent().removeClass('open');
    """),format.raw/*40.5*/("""}"""),format.raw/*40.6*/(""");

    $('#branch-control-input').keyup(function() """),format.raw/*42.49*/("""{"""),format.raw/*42.50*/("""
      """),format.raw/*43.7*/("""updateBranchControlListFilter();
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/(""");

    """),_display_(if(hasWritePermission)/*46.28*/ {_display_(Seq[Any](format.raw/*46.30*/("""
      """),format.raw/*47.7*/("""$('#create-branch').click(function() """),format.raw/*47.44*/("""{"""),format.raw/*47.45*/("""
        """),format.raw/*48.9*/("""$(this).find('input[name="new"]').val($('.dropdown-menu input').val())
        $(this).find('form').submit()
       """),format.raw/*50.8*/("""}"""),format.raw/*50.9*/(""");
    """)))} else {null} ),format.raw/*51.6*/("""

    """),format.raw/*53.5*/("""$('.btn-group').click(function() """),format.raw/*53.38*/("""{"""),format.raw/*53.39*/("""
      """),format.raw/*54.7*/("""$('#branch-control-input').val('');
      //$('.dropdown-menu li').show();
      $('#create-branch').hide();
    """),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""");

    $('#nav-item-branches').click(function(e) """),format.raw/*59.47*/("""{"""),format.raw/*59.48*/("""
      """),format.raw/*60.7*/("""e.stopPropagation();
      updateBranchControlList('branches');
    """),format.raw/*62.5*/("""}"""),format.raw/*62.6*/(""");

    $('#nav-item-tags').click(function(e) """),format.raw/*64.43*/("""{"""),format.raw/*64.44*/("""
      """),format.raw/*65.7*/("""e.stopPropagation();
      updateBranchControlList('tags');
    """),format.raw/*67.5*/("""}"""),format.raw/*67.6*/(""");

    function updateBranchControlList(active) """),format.raw/*69.46*/("""{"""),format.raw/*69.47*/("""
      """),format.raw/*70.7*/("""if (active == 'branches') """),format.raw/*70.33*/("""{"""),format.raw/*70.34*/("""
        """),format.raw/*71.9*/("""$('li#branch-control-tab-branches').addClass('active');
        $('li#branch-control-tab-tags').removeClass('active');

        $('li.branch-control-item-branch').show();
        $('li.branch-control-item-branch > a').addClass('active');

        $('li.branch-control-item-tag').hide();
        $('li.branch-control-item-tag > a').removeClass('active');
        """),_display_(if(hasWritePermission)/*79.32*/ {_display_(Seq[Any](format.raw/*79.34*/("""
          """),format.raw/*80.11*/("""$('#branch-control-input').attr('placeholder', 'Find or create branch ...');
        """)))}else/*81.16*/{_display_(Seq[Any](format.raw/*81.17*/("""
          """),format.raw/*82.11*/("""$('#branch-control-input').attr('placeholder', 'Find branch ...');
        """)))}),format.raw/*83.10*/("""
      """),format.raw/*84.7*/("""}"""),format.raw/*84.8*/(""" """),format.raw/*84.9*/("""else if (active == 'tags') """),format.raw/*84.36*/("""{"""),format.raw/*84.37*/("""
        """),format.raw/*85.9*/("""$('li#branch-control-tab-branches').removeClass('active');
        $('li#branch-control-tab-tags').addClass('active');

        $('li.branch-control-item-branch').hide();
        $('li.branch-control-item-branch > a').removeClass('active');

        $('li.branch-control-item-tag').show();
        $('li.branch-control-item-tag > a').addClass('active');
        $('#branch-control-input').attr('placeholder', 'Find tag ...');
      """),format.raw/*94.7*/("""}"""),format.raw/*94.8*/("""
      """),format.raw/*95.7*/("""updateBranchControlListFilter();
    """),format.raw/*96.5*/("""}"""),format.raw/*96.6*/("""

    """),format.raw/*98.5*/("""function updateBranchControlListFilter() """),format.raw/*98.46*/("""{"""),format.raw/*98.47*/("""
      """),format.raw/*99.7*/("""const inputVal = $('#branch-control-input').val();
      $.each($('#branch-control-input').parent().parent().find('a.active').not('.nav-item'), function(index, elem) """),format.raw/*100.116*/("""{"""),format.raw/*100.117*/("""
        """),format.raw/*101.9*/("""if (!inputVal || !elem.text.trim() || elem.text.trim().toLowerCase().indexOf(inputVal.toLowerCase()) >= 0) """),format.raw/*101.116*/("""{"""),format.raw/*101.117*/("""
          """),format.raw/*102.11*/("""$(elem).parent().show();
        """),format.raw/*103.9*/("""}"""),format.raw/*103.10*/(""" """),format.raw/*103.11*/("""else """),format.raw/*103.16*/("""{"""),format.raw/*103.17*/("""
          """),format.raw/*104.11*/("""$(elem).parent().hide();
        """),format.raw/*105.9*/("""}"""),format.raw/*105.10*/("""
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/(""");
      if ($('li#branch-control-tab-branches.active').length > 0) """),format.raw/*107.66*/("""{"""),format.raw/*107.67*/("""
        """),_display_(if(hasWritePermission)/*108.32*/ {_display_(Seq[Any](format.raw/*108.34*/("""
          """),format.raw/*109.11*/("""if (inputVal) """),format.raw/*109.25*/("""{"""),format.raw/*109.26*/("""
            """),format.raw/*110.13*/("""$('#create-branch').parent().find('li:last-child').show().find('.new-branch').text(inputVal);
          """),format.raw/*111.11*/("""}"""),format.raw/*111.12*/(""" """),format.raw/*111.13*/("""else """),format.raw/*111.18*/("""{"""),format.raw/*111.19*/("""
            """),format.raw/*112.13*/("""$('#create-branch').parent().find('li:last-child').hide();
          """),format.raw/*113.11*/("""}"""),format.raw/*113.12*/("""
        """)))} else {null} ),format.raw/*114.10*/("""
      """),format.raw/*115.7*/("""}"""),format.raw/*115.8*/("""
    """),format.raw/*116.5*/("""}"""),format.raw/*116.6*/("""

    """),format.raw/*118.5*/("""// Initialize the branch control list
    updateBranchControlList('branches');
  """),format.raw/*120.3*/("""}"""),format.raw/*120.4*/(""");
</script>
"""))
      }
    }
  }

  def render(branch:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,hasWritePermission)(body)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,hasWritePermission) => (body) => (context) => apply(branch,repository,hasWritePermission)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/branchcontrol.scala.html
                  HASH: 25c30037a2783a3fca80c533c29df5b2d4e7ae0b
                  MATRIX: 693->1|955->192|1018->228|1035->237|1306->501|1344->503|1374->506|1923->1029|1948->1033|2003->1061|2043->1063|2077->1070|2177->1143|2193->1150|2230->1166|2453->1362|2480->1368|2610->1471|2637->1477|2720->1517|2750->1520|2787->1527|2815->1528|2866->1551|2895->1552|2927->1557|3009->1611|3038->1612|3072->1619|3124->1644|3152->1645|3232->1697|3261->1698|3295->1705|3386->1769|3414->1770|3494->1822|3523->1823|3557->1830|3621->1867|3649->1868|3707->1899|3747->1901|3781->1908|3846->1945|3875->1946|3911->1955|4054->2071|4082->2072|4133->2080|4166->2086|4227->2119|4256->2120|4290->2127|4430->2240|4458->2241|4536->2291|4565->2292|4599->2299|4694->2367|4722->2368|4796->2414|4825->2415|4859->2422|4950->2486|4978->2487|5055->2536|5084->2537|5118->2544|5172->2570|5201->2571|5237->2580|5649->2965|5689->2967|5728->2978|5837->3070|5876->3071|5915->3082|6022->3158|6056->3165|6084->3166|6112->3167|6167->3194|6196->3195|6232->3204|6691->3636|6719->3637|6753->3644|6817->3681|6845->3682|6878->3688|6947->3729|6976->3730|7010->3737|7206->3903|7237->3904|7274->3913|7411->4020|7442->4021|7482->4032|7543->4065|7573->4066|7603->4067|7637->4072|7667->4073|7707->4084|7768->4117|7798->4118|7833->4125|7862->4126|7959->4194|7989->4195|8049->4227|8090->4229|8130->4240|8173->4254|8203->4255|8245->4268|8378->4372|8408->4373|8438->4374|8472->4379|8502->4380|8544->4393|8642->4462|8672->4463|8727->4473|8762->4480|8791->4481|8824->4486|8853->4487|8887->4493|8996->4574|9025->4575
                  LINES: 14->1|19->4|22->5|22->5|26->9|26->9|27->10|36->19|36->19|37->20|37->20|38->21|39->22|39->22|39->22|41->24|41->24|43->26|43->26|46->29|47->30|48->31|49->32|50->33|50->33|51->34|51->34|51->34|52->35|53->36|53->36|55->38|55->38|56->39|57->40|57->40|59->42|59->42|60->43|61->44|61->44|63->46|63->46|64->47|64->47|64->47|65->48|67->50|67->50|68->51|70->53|70->53|70->53|71->54|74->57|74->57|76->59|76->59|77->60|79->62|79->62|81->64|81->64|82->65|84->67|84->67|86->69|86->69|87->70|87->70|87->70|88->71|96->79|96->79|97->80|98->81|98->81|99->82|100->83|101->84|101->84|101->84|101->84|101->84|102->85|111->94|111->94|112->95|113->96|113->96|115->98|115->98|115->98|116->99|117->100|117->100|118->101|118->101|118->101|119->102|120->103|120->103|120->103|120->103|120->103|121->104|122->105|122->105|123->106|123->106|124->107|124->107|125->108|125->108|126->109|126->109|126->109|127->110|128->111|128->111|128->111|128->111|128->111|129->112|130->113|130->113|131->114|132->115|132->115|133->116|133->116|135->118|137->120|137->120
                  -- GENERATED --
              */
          