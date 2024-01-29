
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object blob extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template11[String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],gitbucket.core.util.JGitUtil.ContentInfo,gitbucket.core.util.JGitUtil.CommitInfo,Boolean,Boolean,Boolean,Int,String,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  content: gitbucket.core.util.JGitUtil.ContentInfo,
  latestCommit: gitbucket.core.util.JGitUtil.CommitInfo,
  hasWritePermission: Boolean,
  isBlame: Boolean,
  isLfsFile: Boolean,
  tabSize: Int,
  highlighterTheme: String)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*11.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*12.2*/gitbucket/*12.11*/.core.html.main(s"${(repository.name :: pathList).mkString("/")} at ${branch} - ${repository.owner}/${repository.name}", Some(repository), highlighterTheme)/*12.167*/ {_display_(Seq[Any](format.raw/*12.169*/("""
  """),_display_(/*13.4*/gitbucket/*13.13*/.core.html.menu("files", repository)/*13.49*/{_display_(Seq[Any](format.raw/*13.50*/("""
    """),format.raw/*14.5*/("""<style>
      .prettyprint """),format.raw/*15.20*/("""{"""),format.raw/*15.21*/("""
        """),format.raw/*16.9*/("""tab-size: """),_display_(/*16.20*/tabSize),format.raw/*16.27*/("""
      """),format.raw/*17.7*/("""}"""),format.raw/*17.8*/("""
    """),format.raw/*18.5*/("""</style>
    <div class="head">
      <div class="pull-right hide-if-blame"><div class="btn-group">
        <a href=""""),_display_(/*21.19*/helpers/*21.26*/.url(repository)),format.raw/*21.42*/("""/blob/"""),_display_(/*21.49*/helpers/*21.56*/.encodeRefName((latestCommit.id :: pathList).mkString("/"))),format.raw/*21.115*/("""" data-hotkey="y" style="display: none;">Transfer to URL with SHA</a>
        <a href=""""),_display_(/*22.19*/helpers/*22.26*/.url(repository)),format.raw/*22.42*/("""/find/"""),_display_(/*22.49*/helpers/*22.56*/.encodeRefName(branch)),format.raw/*22.78*/("""" class="btn btn-sm btn-default" data-hotkey="t">Find file</a>
      </div></div>
      <div class="line-age-legend">
        <span>Newer</span>
        <ol>
            <li class="heat1"></li>
            <li class="heat2"></li>
            <li class="heat3"></li>
            <li class="heat4"></li>
            <li class="heat5"></li>
            <li class="heat6"></li>
            <li class="heat7"></li>
            <li class="heat8"></li>
            <li class="heat9"></li>
            <li class="heat10"></li>
        </ol>
        <span>Older</span>
      </div>
      <div id="branchCtrlWrapper" style="display:inline;">
      """),_display_(/*41.8*/gitbucket/*41.17*/.core.helper.html.branchcontrol(branch, repository, hasWritePermission)/*41.88*/{_display_(Seq[Any](format.raw/*41.89*/("""
        """),_display_(/*42.10*/repository/*42.20*/.branchList.map/*42.35*/ { x =>_display_(Seq[Any](format.raw/*42.42*/("""
          """),format.raw/*43.11*/("""<li><a href=""""),_display_(/*43.25*/helpers/*43.32*/.url(repository)),format.raw/*43.48*/("""/blob/"""),_display_(/*43.55*/helpers/*43.62*/.encodeRefName((x :: pathList).mkString("/"))),format.raw/*43.107*/("""">"""),_display_(/*43.110*/gitbucket/*43.119*/.core.helper.html.checkicon(x == branch)),format.raw/*43.159*/(""" """),_display_(/*43.161*/x),format.raw/*43.162*/("""</a></li>
        """)))}),format.raw/*44.10*/("""
      """)))}),format.raw/*45.8*/("""
      """),format.raw/*46.7*/("""</div>
      <a href=""""),_display_(/*47.17*/helpers/*47.24*/.url(repository)),format.raw/*47.40*/("""/tree/"""),_display_(/*47.47*/helpers/*47.54*/.encodeRefName(branch)),format.raw/*47.76*/("""">"""),_display_(/*47.79*/repository/*47.89*/.name),format.raw/*47.94*/("""</a> /
      """),_display_(/*48.8*/pathList/*48.16*/.zipWithIndex.map/*48.33*/ { case (section, i) =>_display_(Seq[Any](format.raw/*48.56*/("""
        """),_display_(if(i == pathList.length - 1)/*49.38*/{_display_(Seq[Any](format.raw/*49.39*/("""
          """),_display_(/*50.12*/section),format.raw/*50.19*/("""
        """)))}else/*51.16*/{_display_(Seq[Any](format.raw/*51.17*/("""
          """),format.raw/*52.11*/("""<a href=""""),_display_(/*52.21*/helpers/*52.28*/.url(repository)),format.raw/*52.44*/("""/tree/"""),_display_(/*52.51*/helpers/*52.58*/.encodeRefName((branch :: pathList.take(i + 1)).mkString("/"))),format.raw/*52.120*/("""">"""),_display_(/*52.123*/section),format.raw/*52.130*/("""</a> /
        """)))}),format.raw/*53.10*/("""
      """)))}),format.raw/*54.8*/("""
      """),_display_(if(isLfsFile)/*55.21*/{_display_(Seq[Any](format.raw/*55.22*/("""
        """),format.raw/*56.9*/("""<span class="label label-info">LFS</span>
      """)))} else {null} ),format.raw/*57.8*/("""
    """),format.raw/*58.5*/("""</div>
    <div class="box-header" style="line-height: 28px;">
      """),_display_(/*60.8*/helpers/*60.15*/.avatarLink(latestCommit, 20)),format.raw/*60.44*/("""
      """),_display_(/*61.8*/helpers/*61.15*/.user(latestCommit.authorName, latestCommit.authorEmailAddress, "username strong")),format.raw/*61.97*/("""
      """),format.raw/*62.7*/("""<span class="muted">"""),_display_(/*62.28*/gitbucket/*62.37*/.core.helper.html.datetimeago(latestCommit.commitTime)),format.raw/*62.91*/("""</span>
      <span class="label label-default">"""),_display_(/*63.42*/helpers/*63.49*/.readableSize(content.size)),format.raw/*63.76*/("""</span>
      <a href=""""),_display_(/*64.17*/helpers/*64.24*/.url(repository)),format.raw/*64.40*/("""/commit/"""),_display_(/*64.49*/latestCommit/*64.61*/.id),format.raw/*64.64*/("""" class="commit-message">"""),_display_(/*64.90*/helpers/*64.97*/.link(latestCommit.summary, repository)),format.raw/*64.136*/("""</a>
      <div class="btn-group pull-right">
        <a class="btn btn-sm btn-default" href=""""),_display_(/*66.50*/helpers/*66.57*/.url(repository)),format.raw/*66.73*/("""/raw/"""),_display_(/*66.79*/latestCommit/*66.91*/.id),format.raw/*66.94*/("""/"""),_display_(/*66.96*/helpers/*66.103*/.encodeRefName(pathList.mkString("/"))),format.raw/*66.141*/("""">Raw</a>
        """),_display_(if(content.viewType == "text")/*67.40*/{_display_(Seq[Any](format.raw/*67.41*/("""
          """),format.raw/*68.11*/("""<a class="btn btn-sm btn-default blame-action" href=""""),_display_(/*68.65*/helpers/*68.72*/.url(repository)),format.raw/*68.88*/("""/blame/"""),_display_(/*68.96*/latestCommit/*68.108*/.id),format.raw/*68.111*/("""/"""),_display_(/*68.113*/helpers/*68.120*/.encodeRefName(pathList.mkString("/"))),format.raw/*68.158*/(""""
            data-url=""""),_display_(/*69.24*/helpers/*69.31*/.url(repository)),format.raw/*69.47*/("""/get-blame/"""),_display_(/*69.59*/helpers/*69.66*/.encodeRefName((latestCommit.id :: pathList).mkString("/"))),format.raw/*69.125*/("""" data-repository=""""),_display_(/*69.145*/helpers/*69.152*/.url(repository)),format.raw/*69.168*/("""">Blame</a>
        """)))} else {null} ),format.raw/*70.10*/("""
        """),format.raw/*71.9*/("""<a class="btn btn-sm btn-default" href=""""),_display_(/*71.50*/helpers/*71.57*/.url(repository)),format.raw/*71.73*/("""/commits/"""),_display_(/*71.83*/helpers/*71.90*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*71.140*/("""">History</a>
        """),_display_(if(hasWritePermission && content.viewType == "text" && repository.branchList.contains(branch))/*72.104*/{_display_(Seq[Any](format.raw/*72.105*/("""
          """),format.raw/*73.11*/("""<a class="btn btn-sm" style="padding-right: 4px;" href=""""),_display_(/*73.68*/helpers/*73.75*/.url(repository)),format.raw/*73.91*/("""/edit/"""),_display_(/*73.98*/helpers/*73.105*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*73.155*/(""""><i class="octicon octicon-pencil" aria-label="Edit"></i></a>
        """)))} else {null} ),format.raw/*74.10*/("""
        """),_display_(if(hasWritePermission && repository.branchList.contains(branch))/*75.74*/{_display_(Seq[Any](format.raw/*75.75*/("""
          """),format.raw/*76.11*/("""<a class="btn btn-sm" style="padding-right: 4px;" href=""""),_display_(/*76.68*/helpers/*76.75*/.url(repository)),format.raw/*76.91*/("""/remove/"""),_display_(/*76.100*/helpers/*76.107*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*76.157*/(""""><i class="octicon octicon-trashcan" aria-label="Remove"></i></a>
        """)))} else {null} ),format.raw/*77.10*/("""
      """),format.raw/*78.7*/("""</div>
    </div>
    """),_display_(/*80.6*/defining(helpers.isRenderable(pathList.last))/*80.51*/{ isRenderable =>_display_(Seq[Any](format.raw/*80.68*/("""
      """),_display_(if(!isBlame && isRenderable)/*81.36*/ {_display_(Seq[Any](format.raw/*81.38*/("""
        """),format.raw/*82.9*/("""<div class="box-content-bottom """),_display_(if(content.viewType == "text")/*82.71*/{_display_(Seq[Any](format.raw/*82.72*/(""" """),format.raw/*82.73*/("""markdown-body """)))} else {null} ),format.raw/*82.88*/(""" """),format.raw/*82.89*/("""" style="padding-left: 20px; padding-right: 20px;">
          """),_display_(/*83.12*/helpers/*83.19*/.renderMarkup(pathList, content.content.getOrElse(""), branch, repository, false, false, true)),format.raw/*83.113*/("""
        """),format.raw/*84.9*/("""</div>
      """)))}else/*85.12*/{_display_(Seq[Any](format.raw/*85.13*/("""
        """),_display_(if(content.viewType == "text")/*86.40*/{_display_(Seq[Any](format.raw/*86.41*/("""
          """),format.raw/*87.11*/("""<div class="box-content-bottom">
            <pre class="prettyprint linenums blob """),_display_(if(!isRenderable)/*88.69*/{_display_(Seq[Any](format.raw/*88.70*/(""" """),format.raw/*88.71*/("""no-renderable """)))} else {null} ),format.raw/*88.86*/(""" """),format.raw/*88.87*/("""">"""),_display_(/*88.90*/content/*88.97*/.content.map(_.replaceAll("^(\r?\n)", "$1$1"))),format.raw/*88.143*/("""</pre>
          </div>
        """)))} else {null} ),format.raw/*90.10*/("""
        """),_display_(if(content.viewType == "image")/*91.41*/{_display_(Seq[Any](format.raw/*91.42*/("""
          """),format.raw/*92.11*/("""<div class="box-content-bottom">
            <img src=""""),_display_(/*93.24*/helpers/*93.31*/.url(repository)),format.raw/*93.47*/("""/raw/"""),_display_(/*93.53*/helpers/*93.60*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*93.110*/(""""/>
          </div>
        """)))} else {null} ),format.raw/*95.10*/("""
        """),_display_(if(content.viewType == "large" || content.viewType == "binary")/*96.73*/{_display_(Seq[Any](format.raw/*96.74*/("""
          """),format.raw/*97.11*/("""<div class="box-content-bottom" style="text-align: center; padding-top: 20px; padding-bottom: 20px;">
            <a href=""""),_display_(/*98.23*/helpers/*98.30*/.url(repository)),format.raw/*98.46*/("""/raw/"""),_display_(/*98.52*/helpers/*98.59*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*98.109*/("""">View Raw</a><br>
            <br>
            (Sorry about that, but we can't show files that are this big right now)
          </div>
        """)))} else {null} ),format.raw/*102.10*/("""
      """)))}),format.raw/*103.8*/("""
    """)))}),format.raw/*104.6*/("""
  """)))}),format.raw/*105.4*/("""
""")))}),format.raw/*106.2*/("""
"""),format.raw/*107.1*/("""<script>
$(window).on('load', function()"""),format.raw/*108.32*/("""{"""),format.raw/*108.33*/("""
  """),format.raw/*109.3*/("""window.onhashchange = function()"""),format.raw/*109.35*/("""{"""),format.raw/*109.36*/("""
    """),format.raw/*110.5*/("""updateHighlighting();
  """),format.raw/*111.3*/("""}"""),format.raw/*111.4*/("""

  """),format.raw/*113.3*/("""const pre = $('pre.prettyprint');
  function updateSourceLineNum() """),format.raw/*114.34*/("""{"""),format.raw/*114.35*/("""
    """),format.raw/*115.5*/("""$('.source-line-num').remove();
    const pos = pre.find('ol.linenums').position();
    if (pos) """),format.raw/*117.14*/("""{"""),format.raw/*117.15*/("""
      """),format.raw/*118.7*/("""$('<div class="source-line-num">').css("""),format.raw/*118.46*/("""{"""),format.raw/*118.47*/("""
        """),format.raw/*119.9*/("""height  : pre.height(),
        width   : '48px',
        cursor  : 'pointer',
        position: 'absolute',
        top     : pos.top + 'px',
        left    : pos.left + 'px'
      """),format.raw/*125.7*/("""}"""),format.raw/*125.8*/(""").click(function(e)"""),format.raw/*125.27*/("""{"""),format.raw/*125.28*/("""
        """),format.raw/*126.9*/("""let pos = $(this).data("pos");
        if (!pos) """),format.raw/*127.19*/("""{"""),format.raw/*127.20*/("""
          """),format.raw/*128.11*/("""pos = $('ol.linenums li').map(function()"""),format.raw/*128.51*/("""{"""),format.raw/*128.52*/(""" """),format.raw/*128.53*/("""return """),format.raw/*128.60*/("""{"""),format.raw/*128.61*/(""" """),format.raw/*128.62*/("""id: $(this).attr("id"), top: $(this).position().top"""),format.raw/*128.113*/("""}"""),format.raw/*128.114*/(""" """),format.raw/*128.115*/("""}"""),format.raw/*128.116*/(""").toArray();
          $(this).data("pos",pos);
        """),format.raw/*130.9*/("""}"""),format.raw/*130.10*/("""
        """),format.raw/*131.9*/("""let i = 0;
        for(i = 0; i < pos.length - 1; i++)"""),format.raw/*132.44*/("""{"""),format.raw/*132.45*/("""
          """),format.raw/*133.11*/("""if(pos[i + 1].top > e.pageY)"""),format.raw/*133.39*/("""{"""),format.raw/*133.40*/("""
            """),format.raw/*134.13*/("""break;
          """),format.raw/*135.11*/("""}"""),format.raw/*135.12*/("""
        """),format.raw/*136.9*/("""}"""),format.raw/*136.10*/("""
        """),format.raw/*137.9*/("""const line    = pos[i].id.replace(/^L/,'');
        const hash    = location.hash;
        const baseUrl = location.toString().split("#")[0];
        if (e.shiftKey == true && hash.match(/#L\d+(-L\d+)?/)) """),format.raw/*140.64*/("""{"""),format.raw/*140.65*/("""
          """),format.raw/*141.11*/("""const fragments = hash.split('-');
          window.history.pushState('', '', baseUrl + fragments[0] + '-L' + line);
        """),format.raw/*143.9*/("""}"""),format.raw/*143.10*/(""" """),format.raw/*143.11*/("""else """),format.raw/*143.16*/("""{"""),format.raw/*143.17*/("""
          """),format.raw/*144.11*/("""const p = $("#L" + line).attr('id', '');
          window.history.pushState('', '', baseUrl + '#L' + line);
          p.attr('id','L' + line);
        """),format.raw/*147.9*/("""}"""),format.raw/*147.10*/("""
        """),format.raw/*148.9*/("""$("#branchCtrlWrapper .btn .muted").text("tree:");
        $("#branchCtrlWrapper .btn .strong").text(""""),_display_(/*149.53*/latestCommit/*149.65*/.id.substring(0, 10)),format.raw/*149.85*/("""");
        getSelection().empty();
        updateHighlighting();
      """),format.raw/*152.7*/("""}"""),format.raw/*152.8*/(""").appendTo(pre);
      updateHighlighting();
    """),format.raw/*154.5*/("""}"""),format.raw/*154.6*/(""" """),format.raw/*154.7*/("""else """),format.raw/*154.12*/("""{"""),format.raw/*154.13*/("""
      """),format.raw/*155.7*/("""// Maybe code view is not initialized yet. Retry until succeed.
      setTimeout(updateSourceLineNum, 300);
    """),format.raw/*157.5*/("""}"""),format.raw/*157.6*/("""
  """),format.raw/*158.3*/("""}"""),format.raw/*158.4*/("""
  """),format.raw/*159.3*/("""const repository = $('.blame-action').data('repository');
  $('.blame-action').click(function(e)"""),format.raw/*160.39*/("""{"""),format.raw/*160.40*/("""
    """),format.raw/*161.5*/("""if(history.pushState && $('pre.prettyprint.no-renderable').length)"""),format.raw/*161.71*/("""{"""),format.raw/*161.72*/("""
      """),format.raw/*162.7*/("""e.preventDefault();
      history.pushState(null, null, this.href);
      updateBlame();
    """),format.raw/*165.5*/("""}"""),format.raw/*165.6*/("""
  """),format.raw/*166.3*/("""}"""),format.raw/*166.4*/(""");

  function updateBlame()"""),format.raw/*168.25*/("""{"""),format.raw/*168.26*/("""
    """),format.raw/*169.5*/("""const m = /\/(blame|blob)(\/.*)$/.exec(location.href);
    const mode = m[1];
    $('.blame-action').toggleClass("active", mode=='blame').attr('href', repository + (m[1] == 'blame' ? '/blob' : '/blame') + m[2]);
    if(pre.parents("div.box-content-bottom").find(".blame").length)"""),format.raw/*172.68*/("""{"""),format.raw/*172.69*/("""
      """),format.raw/*173.7*/("""pre.parent().toggleClass("blame-container", mode == 'blame');
      updateSourceLineNum();
      return;
    """),format.raw/*176.5*/("""}"""),format.raw/*176.6*/("""
    """),format.raw/*177.5*/("""if(mode == 'blob')"""),format.raw/*177.23*/("""{"""),format.raw/*177.24*/("""
      """),format.raw/*178.7*/("""updateSourceLineNum();
      return;
    """),format.raw/*180.5*/("""}"""),format.raw/*180.6*/("""
    """),format.raw/*181.5*/("""$(document.body).toggleClass('no-box-shadow', document.body.style.boxShadow === undefined);
    $('.blame-action').addClass("active");
    const base = $('<div class="blame">').css("""),format.raw/*183.47*/("""{"""),format.raw/*183.48*/("""height: pre.height()"""),format.raw/*183.68*/("""}"""),format.raw/*183.69*/(""").prependTo(pre.parents("div.box-content-bottom"));
    base.parent().addClass("blame-container");
    updateSourceLineNum();
    $.get($('.blame-action').data('url')).done(function(data)"""),format.raw/*186.62*/("""{"""),format.raw/*186.63*/("""
      """),format.raw/*187.7*/("""let blame = data.blame;
      let lastDiv;
      const now = new Date().getTime();
      const index = [];
      for(let i = 0; i < blame.length; i++)"""),format.raw/*191.44*/("""{"""),format.raw/*191.45*/("""
        """),format.raw/*192.9*/("""for(let j = 0; j < blame[i].lines.length; j++)"""),format.raw/*192.55*/("""{"""),format.raw/*192.56*/("""
          """),format.raw/*193.11*/("""index[blame[i].lines[j]] = blame[i];
        """),format.raw/*194.9*/("""}"""),format.raw/*194.10*/("""
      """),format.raw/*195.7*/("""}"""),format.raw/*195.8*/("""

      """),format.raw/*197.7*/("""$('pre.prettyprint ol.linenums li').each(function(i, e)"""),format.raw/*197.62*/("""{"""),format.raw/*197.63*/("""
        """),format.raw/*198.9*/("""const p = $(e).position();
        const h = $(e).height();
        if(blame == index[i])"""),format.raw/*200.30*/("""{"""),format.raw/*200.31*/("""
          """),format.raw/*201.11*/("""lastDiv.css("min-height",(p.top + h + 1) - lastDiv.position().top);
        """),format.raw/*202.9*/("""}"""),format.raw/*202.10*/(""" """),format.raw/*202.11*/("""else """),format.raw/*202.16*/("""{"""),format.raw/*202.17*/("""
          """),format.raw/*203.11*/("""$(e).addClass('blame-sep')
          blame = index[i];
          const sha = $('<div class="blame-sha">')
             .append($('<a>').attr("href", data.root + '/commit/' + blame.id).text(blame.id.substr(0, 7)));
          if (blame.prev) """),format.raw/*207.27*/("""{"""),format.raw/*207.28*/("""
             """),format.raw/*208.14*/("""sha.append($('<br />'))
             .append($('<a class="muted-link">').text('prev').attr("href", data.root + '/blame/' + blame.prev + '/' + (blame.prevPath || data.path)));
          """),format.raw/*210.11*/("""}"""),format.raw/*210.12*/("""
          """),format.raw/*211.11*/("""lastDiv = $('<div class="blame-info">')
           .addClass('heat' + Math.min(10, Math.max(1, Math.ceil((now - blame.commited) / (24 * 3600 * 1000 * 70)))))
           .toggleClass('blame-last', blame.id == data.last)
           .data('line', (i + 1))
           .css("""),format.raw/*215.17*/("""{"""),format.raw/*215.18*/("""
             """),format.raw/*216.14*/(""""top"        : p.top + 'px',
             "min-height" : h + 'px'
           """),format.raw/*218.12*/("""}"""),format.raw/*218.13*/(""")
           .append(sha)
           .append($(blame.avatar).addClass('avatar').css("""),format.raw/*220.59*/("""{"""),format.raw/*220.60*/(""""float": "left""""),format.raw/*220.75*/("""}"""),format.raw/*220.76*/("""))
           .append($('<div class="blame-commit-title">').text(blame.message))
           .append($('<div class="muted">').html(blame.author + " authed " + blame.authed))
           .appendTo(base);
        """),format.raw/*224.9*/("""}"""),format.raw/*224.10*/("""
      """),format.raw/*225.7*/("""}"""),format.raw/*225.8*/(""");
    """),format.raw/*226.5*/("""}"""),format.raw/*226.6*/(""");
    return false;
  """),format.raw/*228.3*/("""}"""),format.raw/*228.4*/(""";

  $(document).on('expanded.pushMenu collapsed.pushMenu', function(e)"""),format.raw/*230.69*/("""{"""),format.raw/*230.70*/("""
    """),format.raw/*231.5*/("""setTimeout(updateBlame, 300);
  """),format.raw/*232.3*/("""}"""),format.raw/*232.4*/(""");

  updateBlame();
"""),format.raw/*235.1*/("""}"""),format.raw/*235.2*/(""");

let scrolling = false;

/**
 * Highlight lines which are specified by URL hash.
 */
function updateHighlighting() """),format.raw/*242.31*/("""{"""),format.raw/*242.32*/("""
  """),format.raw/*243.3*/("""const hash = location.hash;
  const isDark = """),_display_(/*244.19*/{highlighterTheme.contains("dark").toString}),format.raw/*244.63*/(""";
  if (hash.match(/#L\d+(-L\d+)?/)) """),format.raw/*245.36*/("""{"""),format.raw/*245.37*/("""
    """),format.raw/*246.5*/("""if (isDark) """),format.raw/*246.17*/("""{"""),format.raw/*246.18*/("""
      """),format.raw/*247.7*/("""$('li.highlight-dark').removeClass('highlight-dark');
    """),format.raw/*248.5*/("""}"""),format.raw/*248.6*/(""" """),format.raw/*248.7*/("""else """),format.raw/*248.12*/("""{"""),format.raw/*248.13*/("""
      """),format.raw/*249.7*/("""$('li.highlight').removeClass('highlight');
    """),format.raw/*250.5*/("""}"""),format.raw/*250.6*/("""
    """),format.raw/*251.5*/("""const fragments = hash.substr(1).split('-');
    if (fragments.length == 1) """),format.raw/*252.32*/("""{"""),format.raw/*252.33*/("""
      """),format.raw/*253.7*/("""if (isDark) """),format.raw/*253.19*/("""{"""),format.raw/*253.20*/("""
        """),format.raw/*254.9*/("""$('#' + fragments[0]).addClass('highlight-dark');
      """),format.raw/*255.7*/("""}"""),format.raw/*255.8*/(""" """),format.raw/*255.9*/("""else """),format.raw/*255.14*/("""{"""),format.raw/*255.15*/("""
        """),format.raw/*256.9*/("""$('#' + fragments[0]).addClass('highlight');
      """),format.raw/*257.7*/("""}"""),format.raw/*257.8*/("""
      """),format.raw/*258.7*/("""if(!scrolling)"""),format.raw/*258.21*/("""{"""),format.raw/*258.22*/("""
        """),format.raw/*259.9*/("""$(window).scrollTop($('#' + fragments[0]).offset().top);
      """),format.raw/*260.7*/("""}"""),format.raw/*260.8*/("""
    """),format.raw/*261.5*/("""}"""),format.raw/*261.6*/(""" """),format.raw/*261.7*/("""else if(fragments.length > 1)"""),format.raw/*261.36*/("""{"""),format.raw/*261.37*/("""
      """),format.raw/*262.7*/("""const start = parseInt(fragments[0].substr(1));
      const end   = parseInt(fragments[1].substr(1));
      for (let i = start; i <= end; i++) """),format.raw/*264.42*/("""{"""),format.raw/*264.43*/("""
        """),format.raw/*265.9*/("""if (isDark) """),format.raw/*265.21*/("""{"""),format.raw/*265.22*/("""
          """),format.raw/*266.11*/("""$('#L' + i).addClass('highlight-dark');
        """),format.raw/*267.9*/("""}"""),format.raw/*267.10*/(""" """),format.raw/*267.11*/("""else """),format.raw/*267.16*/("""{"""),format.raw/*267.17*/("""
          """),format.raw/*268.11*/("""$('#L' + i).addClass('highlight');
        """),format.raw/*269.9*/("""}"""),format.raw/*269.10*/("""
      """),format.raw/*270.7*/("""}"""),format.raw/*270.8*/("""
      """),format.raw/*271.7*/("""if (!scrolling) """),format.raw/*271.23*/("""{"""),format.raw/*271.24*/("""
        """),format.raw/*272.9*/("""$(window).scrollTop($('#' + fragments[0]).offset().top);
      """),format.raw/*273.7*/("""}"""),format.raw/*273.8*/("""
    """),format.raw/*274.5*/("""}"""),format.raw/*274.6*/("""
  """),format.raw/*275.3*/("""}"""),format.raw/*275.4*/("""
  """),format.raw/*276.3*/("""scrolling = true;
"""),format.raw/*277.1*/("""}"""),format.raw/*277.2*/("""
"""),format.raw/*278.1*/("""</script>
"""))
      }
    }
  }

  def render(branch:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,pathList:List[String],content:gitbucket.core.util.JGitUtil.ContentInfo,latestCommit:gitbucket.core.util.JGitUtil.CommitInfo,hasWritePermission:Boolean,isBlame:Boolean,isLfsFile:Boolean,tabSize:Int,highlighterTheme:String,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,content,latestCommit,hasWritePermission,isBlame,isLfsFile,tabSize,highlighterTheme)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],gitbucket.core.util.JGitUtil.ContentInfo,gitbucket.core.util.JGitUtil.CommitInfo,Boolean,Boolean,Boolean,Int,String) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,content,latestCommit,hasWritePermission,isBlame,isLfsFile,tabSize,highlighterTheme) => (context) => apply(branch,repository,pathList,content,latestCommit,hasWritePermission,isBlame,isLfsFile,tabSize,highlighterTheme)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/blob.scala.html
                  HASH: f5fa6207fa359dce5f9585b096fdd8aebdd82da9
                  MATRIX: 799->1|1266->396|1330->432|1348->441|1514->597|1555->599|1585->603|1603->612|1648->648|1687->649|1719->654|1774->681|1803->682|1839->691|1877->702|1905->709|1939->716|1967->717|1999->722|2144->840|2160->847|2197->863|2231->870|2247->877|2328->936|2443->1024|2459->1031|2496->1047|2530->1054|2546->1061|2589->1083|3254->1722|3272->1731|3352->1802|3391->1803|3428->1813|3447->1823|3471->1838|3516->1845|3555->1856|3596->1870|3612->1877|3649->1893|3683->1900|3699->1907|3766->1952|3797->1955|3816->1964|3878->2004|3908->2006|3931->2007|3981->2026|4019->2034|4053->2041|4103->2064|4119->2071|4156->2087|4190->2094|4206->2101|4249->2123|4279->2126|4298->2136|4324->2141|4364->2155|4381->2163|4407->2180|4468->2203|4533->2241|4572->2242|4611->2254|4639->2261|4672->2277|4711->2278|4750->2289|4787->2299|4803->2306|4840->2322|4874->2329|4890->2336|4974->2398|5005->2401|5034->2408|5081->2424|5119->2432|5167->2453|5206->2454|5242->2463|5334->2512|5366->2517|5462->2587|5478->2594|5528->2623|5562->2631|5578->2638|5681->2720|5715->2727|5763->2748|5781->2757|5856->2811|5932->2860|5948->2867|5996->2894|6047->2918|6063->2925|6100->2941|6136->2950|6157->2962|6181->2965|6234->2991|6250->2998|6311->3037|6433->3132|6449->3139|6486->3155|6519->3161|6540->3173|6564->3176|6593->3178|6610->3185|6670->3223|6746->3272|6785->3273|6824->3284|6905->3338|6921->3345|6958->3361|6993->3369|7015->3381|7040->3384|7070->3386|7087->3393|7147->3431|7199->3456|7215->3463|7252->3479|7291->3491|7307->3498|7388->3557|7436->3577|7453->3584|7491->3600|7556->3621|7592->3630|7660->3671|7676->3678|7713->3694|7750->3704|7766->3711|7838->3761|7983->3878|8023->3879|8062->3890|8146->3947|8162->3954|8199->3970|8233->3977|8250->3984|8322->4034|8438->4106|8539->4180|8578->4181|8617->4192|8701->4249|8717->4256|8754->4272|8791->4281|8808->4288|8880->4338|9000->4414|9034->4421|9083->4444|9137->4489|9192->4506|9255->4542|9295->4544|9331->4553|9420->4615|9459->4616|9488->4617|9547->4632|9576->4633|9666->4696|9682->4703|9798->4797|9834->4806|9871->4824|9910->4825|9977->4865|10016->4866|10055->4877|10183->4978|10222->4979|10251->4980|10310->4995|10339->4996|10369->4999|10385->5006|10453->5052|10530->5085|10598->5126|10637->5127|10676->5138|10759->5194|10775->5201|10812->5217|10845->5223|10861->5230|10933->5280|11007->5310|11107->5383|11146->5384|11185->5395|11336->5519|11352->5526|11389->5542|11422->5548|11438->5555|11510->5605|11701->5751|11740->5759|11777->5765|11812->5769|11845->5771|11874->5772|11943->5812|11973->5813|12004->5816|12065->5848|12095->5849|12128->5854|12180->5878|12209->5879|12241->5883|12337->5950|12367->5951|12400->5956|12526->6053|12556->6054|12591->6061|12659->6100|12689->6101|12726->6110|12937->6293|12966->6294|13014->6313|13044->6314|13081->6323|13159->6372|13189->6373|13229->6384|13298->6424|13328->6425|13358->6426|13394->6433|13424->6434|13454->6435|13535->6486|13566->6487|13597->6488|13628->6489|13712->6545|13742->6546|13779->6555|13862->6609|13892->6610|13932->6621|13989->6649|14019->6650|14061->6663|14107->6680|14137->6681|14174->6690|14204->6691|14241->6700|14475->6905|14505->6906|14545->6917|14698->7042|14728->7043|14758->7044|14792->7049|14822->7050|14862->7061|15041->7212|15071->7213|15108->7222|15239->7325|15261->7337|15303->7357|15403->7429|15432->7430|15509->7479|15538->7480|15567->7481|15601->7486|15631->7487|15666->7494|15806->7606|15835->7607|15866->7610|15895->7611|15926->7614|16051->7710|16081->7711|16114->7716|16209->7782|16239->7783|16274->7790|16395->7883|16424->7884|16455->7887|16484->7888|16541->7916|16571->7917|16604->7922|16912->8201|16942->8202|16977->8209|17114->8318|17143->8319|17176->8324|17223->8342|17253->8343|17288->8350|17357->8391|17386->8392|17419->8397|17629->8578|17659->8579|17708->8599|17738->8600|17954->8787|17984->8788|18019->8795|18198->8945|18228->8946|18265->8955|18340->9001|18370->9002|18410->9013|18483->9058|18513->9059|18548->9066|18577->9067|18613->9075|18697->9130|18727->9131|18764->9140|18882->9229|18912->9230|18952->9241|19056->9317|19086->9318|19116->9319|19150->9324|19180->9325|19220->9336|19489->9576|19519->9577|19562->9591|19776->9776|19806->9777|19846->9788|20144->10057|20174->10058|20217->10072|20323->10149|20353->10150|20466->10234|20496->10235|20540->10250|20570->10251|20807->10460|20837->10461|20872->10468|20901->10469|20936->10476|20965->10477|21016->10500|21045->10501|21145->10572|21175->10573|21208->10578|21268->10610|21297->10611|21346->10632|21375->10633|21522->10751|21552->10752|21583->10755|21657->10801|21723->10845|21789->10882|21819->10883|21852->10888|21893->10900|21923->10901|21958->10908|22044->10966|22073->10967|22102->10968|22136->10973|22166->10974|22201->10981|22277->11029|22306->11030|22339->11035|22444->11111|22474->11112|22509->11119|22550->11131|22580->11132|22617->11141|22701->11197|22730->11198|22759->11199|22793->11204|22823->11205|22860->11214|22939->11265|22968->11266|23003->11273|23046->11287|23076->11288|23113->11297|23204->11360|23233->11361|23266->11366|23295->11367|23324->11368|23382->11397|23412->11398|23447->11405|23619->11548|23649->11549|23686->11558|23727->11570|23757->11571|23797->11582|23873->11630|23903->11631|23933->11632|23967->11637|23997->11638|24037->11649|24108->11692|24138->11693|24173->11700|24202->11701|24237->11708|24282->11724|24312->11725|24349->11734|24440->11797|24469->11798|24502->11803|24531->11804|24562->11807|24591->11808|24622->11811|24668->11829|24697->11830|24726->11831
                  LINES: 14->1|26->11|29->12|29->12|29->12|29->12|30->13|30->13|30->13|30->13|31->14|32->15|32->15|33->16|33->16|33->16|34->17|34->17|35->18|38->21|38->21|38->21|38->21|38->21|38->21|39->22|39->22|39->22|39->22|39->22|39->22|58->41|58->41|58->41|58->41|59->42|59->42|59->42|59->42|60->43|60->43|60->43|60->43|60->43|60->43|60->43|60->43|60->43|60->43|60->43|60->43|61->44|62->45|63->46|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|65->48|65->48|65->48|65->48|66->49|66->49|67->50|67->50|68->51|68->51|69->52|69->52|69->52|69->52|69->52|69->52|69->52|69->52|69->52|70->53|71->54|72->55|72->55|73->56|74->57|75->58|77->60|77->60|77->60|78->61|78->61|78->61|79->62|79->62|79->62|79->62|80->63|80->63|80->63|81->64|81->64|81->64|81->64|81->64|81->64|81->64|81->64|81->64|83->66|83->66|83->66|83->66|83->66|83->66|83->66|83->66|83->66|84->67|84->67|85->68|85->68|85->68|85->68|85->68|85->68|85->68|85->68|85->68|85->68|86->69|86->69|86->69|86->69|86->69|86->69|86->69|86->69|86->69|87->70|88->71|88->71|88->71|88->71|88->71|88->71|88->71|89->72|89->72|90->73|90->73|90->73|90->73|90->73|90->73|90->73|91->74|92->75|92->75|93->76|93->76|93->76|93->76|93->76|93->76|93->76|94->77|95->78|97->80|97->80|97->80|98->81|98->81|99->82|99->82|99->82|99->82|99->82|99->82|100->83|100->83|100->83|101->84|102->85|102->85|103->86|103->86|104->87|105->88|105->88|105->88|105->88|105->88|105->88|105->88|105->88|107->90|108->91|108->91|109->92|110->93|110->93|110->93|110->93|110->93|110->93|112->95|113->96|113->96|114->97|115->98|115->98|115->98|115->98|115->98|115->98|119->102|120->103|121->104|122->105|123->106|124->107|125->108|125->108|126->109|126->109|126->109|127->110|128->111|128->111|130->113|131->114|131->114|132->115|134->117|134->117|135->118|135->118|135->118|136->119|142->125|142->125|142->125|142->125|143->126|144->127|144->127|145->128|145->128|145->128|145->128|145->128|145->128|145->128|145->128|145->128|145->128|145->128|147->130|147->130|148->131|149->132|149->132|150->133|150->133|150->133|151->134|152->135|152->135|153->136|153->136|154->137|157->140|157->140|158->141|160->143|160->143|160->143|160->143|160->143|161->144|164->147|164->147|165->148|166->149|166->149|166->149|169->152|169->152|171->154|171->154|171->154|171->154|171->154|172->155|174->157|174->157|175->158|175->158|176->159|177->160|177->160|178->161|178->161|178->161|179->162|182->165|182->165|183->166|183->166|185->168|185->168|186->169|189->172|189->172|190->173|193->176|193->176|194->177|194->177|194->177|195->178|197->180|197->180|198->181|200->183|200->183|200->183|200->183|203->186|203->186|204->187|208->191|208->191|209->192|209->192|209->192|210->193|211->194|211->194|212->195|212->195|214->197|214->197|214->197|215->198|217->200|217->200|218->201|219->202|219->202|219->202|219->202|219->202|220->203|224->207|224->207|225->208|227->210|227->210|228->211|232->215|232->215|233->216|235->218|235->218|237->220|237->220|237->220|237->220|241->224|241->224|242->225|242->225|243->226|243->226|245->228|245->228|247->230|247->230|248->231|249->232|249->232|252->235|252->235|259->242|259->242|260->243|261->244|261->244|262->245|262->245|263->246|263->246|263->246|264->247|265->248|265->248|265->248|265->248|265->248|266->249|267->250|267->250|268->251|269->252|269->252|270->253|270->253|270->253|271->254|272->255|272->255|272->255|272->255|272->255|273->256|274->257|274->257|275->258|275->258|275->258|276->259|277->260|277->260|278->261|278->261|278->261|278->261|278->261|279->262|281->264|281->264|282->265|282->265|282->265|283->266|284->267|284->267|284->267|284->267|284->267|285->268|286->269|286->269|287->270|287->270|288->271|288->271|288->271|289->272|290->273|290->273|291->274|291->274|292->275|292->275|293->276|294->277|294->277|295->278
                  -- GENERATED --
              */
          