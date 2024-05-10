import React from 'react'
import styles from './Nav.module.scss'

const Nav = () => {
	return (
		<nav className={styles.nav}>
			<ul>
				<li>
					회원가입
				</li>
				<li>
					로그인
				</li>
			</ul>
		</nav>
	
	)
}

export default Nav