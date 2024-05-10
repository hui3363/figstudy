import React from 'react'
import styles from './Nav.module.scss'
import { Link } from 'react-router-dom'

const Nav = () => {
	return (
		<nav className={styles.nav}>
			<ul>
				<li>
					<div className={styles.menu}>
						<Link to={"/study"}>내 서재</Link>
					</div>
				</li>
				<li>
					<div className={styles.menu}>
						<Link to={"/curation"}>둘러보기</Link>
					</div>
				</li>
				<li>
					<div className={styles.menu}>
						<Link to={"/mypage"}>마이페이지</Link>
					</div>
				</li>
			</ul>
		</nav>
	
	)
}

export default Nav